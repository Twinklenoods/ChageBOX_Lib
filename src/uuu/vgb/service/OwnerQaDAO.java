package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.OwnerQa;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;

public class OwnerQaDAO {

	private static final String INSERT_OWNERQA=" INSERT INTO `ownerqas` (`id`, `ownerId`, `customerId`, `ownerQA`) \n" 
			+ "    VALUES(?,?,?,?)";

	public void insert(OwnerQa q) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(INSERT_OWNERQA);//3.準備指令
		){
			//3.1傳入?值
			pstmt.setInt(1,q.getId());//3.1 自動
			pstmt.setString(2,q.getOwnerId().getId());
			pstmt.setString(3,q.getCustomerId().getId());
			pstmt.setString(4,q.getOwnerQA());
			
			
			
			
			 pstmt.executeUpdate();//4.執行指令
			
		} catch (SQLIntegrityConstraintViolationException e) {
			String key="";
			if(e.getMessage().indexOf("PRIMSRY")>=0) {
				key="id";
			}
			throw new VGBException("問答已重複-"+key+"問答重複註冊",e);
		} catch (SQLException e) {
				throw new VGBException("問答新增失敗",e);
		} 
	}
	private static final String SELECT_OWNERQA_BY_OWNERID="SELECT"
			+" o.ownerId, o.customerId, o.ownerQA, createTime , c.name, c2.name, answer "
			+" FROM vgb.ownerqas AS o JOIN vgb.customers AS c ON o.ownerId = c.id JOIN vgb.customers AS c2 ON o.customerId = c2.id "
			+ " WHERE o.ownerId=? and o.customerId=?";
			
			public  List<OwnerQa> selectOwnerQaByID(String ownerID, String customerID) throws VGBException{
				List<OwnerQa> list =new ArrayList<>();
				
				
				try(
						Connection connection =RDBConnection.getConnection();//1.2取得連線物件
						PreparedStatement pstmt =connection.prepareStatement(SELECT_OWNERQA_BY_OWNERID);//3.準備指令
						){
					//3.1塞植入ownerID
					pstmt.setString(1,ownerID);
					pstmt.setString(2,customerID);
					//4.執行指令
					try(
							ResultSet rs= pstmt.executeQuery();
							){
						//5.處理rs
						while(rs.next()) {
							OwnerQa o=new OwnerQa();
							Customer Owner= new Customer();
							Customer Customer= new Customer();
							
							o.setOwnerQA(rs.getString("o.ownerQA"));
							o.setCreateTime(rs.getString("createTime"));
							o.setAnswer(rs.getString("answer"));
							
							Owner.setId(rs.getString("o.ownerId"));
							Owner.setName(rs.getString("c.name"));
							o.setOwnerId(Owner);
							
							Customer.setId(rs.getString("o.customerId"));
							Customer.setName(rs.getString("c2.name"));
							o.setCustomerId(Customer);
							
							list.add(o);
								
						}
						
					}
				} catch (SQLException e) {

					
					throw new VGBException("用編號查詢失敗",e);		
				}
				 
				return list;
			}
			
			private static final String SELECT_OWNERQA_BY_OWNERID_ONLY="SELECT"
					+" o.id, o.ownerId, o.customerId, o.ownerQA, createTime , c.name, c2.name, answer "
					+" FROM vgb.ownerqas AS o JOIN vgb.customers AS c ON o.ownerId = c.id JOIN vgb.customers AS c2 ON o.customerId = c2.id "
					+ " WHERE o.ownerId=? ";
					
					public  List<OwnerQa> selectOwnerQaByIdOnly(String ownerID) throws VGBException{
						List<OwnerQa> list =new ArrayList<>();
						
						
						try(
								Connection connection =RDBConnection.getConnection();//1.2取得連線物件
								PreparedStatement pstmt =connection.prepareStatement(SELECT_OWNERQA_BY_OWNERID_ONLY);//3.準備指令
								){
							//3.1塞植入ownerID
							pstmt.setString(1,ownerID);
							
							//4.執行指令
							try(
									ResultSet rs= pstmt.executeQuery();
									){
								//5.處理rs
								while(rs.next()) {
									OwnerQa o=new OwnerQa();
									Customer Owner= new Customer();
									Customer Customer= new Customer();
									o.setId(rs.getInt("o.id"));
									
									o.setOwnerQA(rs.getString("o.ownerQA"));
									o.setCreateTime(rs.getString("createTime"));
									o.setAnswer(rs.getString("answer"));
									
									Owner.setId(rs.getString("o.ownerId"));
									Owner.setName(rs.getString("c.name"));
									o.setOwnerId(Owner);
									
									Customer.setId(rs.getString("o.customerId"));
									Customer.setName(rs.getString("c2.name"));
									o.setCustomerId(Customer);
									
									list.add(o);
										
								}
								
							}
						} catch (SQLException e) {

							
							throw new VGBException("用編號查詢失敗",e);		
						}
						 
						return list;
					}
					private static final String SELECT_OWNERQA_BY_OWNERID_OFF="SELECT"
							+" o.id,o.ownerId, o.customerId, o.ownerQA, createTime , c.name, c2.name, answer "
							+" FROM vgb.ownerqas AS o JOIN vgb.customers AS c ON o.ownerId = c.id JOIN vgb.customers AS c2 ON o.customerId = c2.id "
							+ " WHERE o.ownerId=? AND answer IS NULL ";
							
							public  List<OwnerQa> selectOwnerQaByIdOFF(String ownerID) throws VGBException{
								List<OwnerQa> list =new ArrayList<>();
								
								
								try(
										Connection connection =RDBConnection.getConnection();//1.2取得連線物件
										PreparedStatement pstmt =connection.prepareStatement(SELECT_OWNERQA_BY_OWNERID_OFF);//3.準備指令
										){
									//3.1塞植入ownerID
									pstmt.setString(1,ownerID);
									
									//4.執行指令
									try(
											ResultSet rs= pstmt.executeQuery();
											){
										//5.處理rs
										while(rs.next()) {
											OwnerQa o=new OwnerQa();
											Customer Owner= new Customer();
											Customer Customer= new Customer();
											
											o.setId(rs.getInt("o.id"));
											o.setOwnerQA(rs.getString("o.ownerQA"));
											o.setCreateTime(rs.getString("createTime"));
											o.setAnswer(rs.getString("answer"));
											
											Owner.setId(rs.getString("o.ownerId"));
											Owner.setName(rs.getString("c.name"));
											o.setOwnerId(Owner);
											
											Customer.setId(rs.getString("o.customerId"));
											Customer.setName(rs.getString("c2.name"));
											o.setCustomerId(Customer);
											
											list.add(o);
												
										}
										
									}
								} catch (SQLException e) {

									
									throw new VGBException("用編號查詢失敗",e);		
								}
								 
								return list;
							}
							
							private static final String SELECT_OWNERQA_BY_OWNERID_ON="SELECT"
									+" o.id,o.ownerId, o.customerId, o.ownerQA, createTime , c.name, c2.name, answer "
									+" FROM vgb.ownerqas AS o JOIN vgb.customers AS c ON o.ownerId = c.id JOIN vgb.customers AS c2 ON o.customerId = c2.id "
									+ " WHERE o.ownerId=? AND answer IS NOT NULL ";
									
									public  List<OwnerQa> selectOwnerQaByIdOn(String ownerID) throws VGBException{
										List<OwnerQa> list =new ArrayList<>();
										
										
										try(
												Connection connection =RDBConnection.getConnection();//1.2取得連線物件
												PreparedStatement pstmt =connection.prepareStatement(SELECT_OWNERQA_BY_OWNERID_ON);//3.準備指令
												){
											//3.1塞植入ownerID
											pstmt.setString(1,ownerID);
											
											//4.執行指令
											try(
													ResultSet rs= pstmt.executeQuery();
													){
												//5.處理rs
												while(rs.next()) {
													OwnerQa o=new OwnerQa();
													Customer Owner= new Customer();
													Customer Customer= new Customer();
													
													o.setId(rs.getInt("o.id"));
													o.setOwnerQA(rs.getString("o.ownerQA"));
													o.setCreateTime(rs.getString("createTime"));
													o.setAnswer(rs.getString("answer"));
													
													Owner.setId(rs.getString("o.ownerId"));
													Owner.setName(rs.getString("c.name"));
													o.setOwnerId(Owner);
													
													Customer.setId(rs.getString("o.customerId"));
													Customer.setName(rs.getString("c2.name"));
													o.setCustomerId(Customer);
													
													list.add(o);
														
												}
												
											}
										} catch (SQLException e) {

											
											throw new VGBException("用編號查詢失敗",e);		
										}
										 
										return list;
									}
									
									 private static final String UPDATE_OWNERQA=" UPDATE ownerqas"
												+" SET answer=?"
												+" WHERE Id=?";

									public void updownQA(OwnerQa o) throws VGBException{
											
											try (
												Connection connection =RDBConnection.getConnection();//1.2.取得連線
												PreparedStatement pstmt =connection.prepareStatement(UPDATE_OWNERQA);//3.準備指令
											){
												//3.1傳入?值
												//3.1
												pstmt.setString(1,o.getAnswer());
												
												
												pstmt.setInt(2,o.getId());
												pstmt.executeUpdate();//4.執行指令
												
											} catch (SQLIntegrityConstraintViolationException e) {
												String key="";
												
												throw new VGBException("回復已重複-"+key+"回復已重複",e);
											} catch (SQLException e) {
													throw new VGBException("回復失敗",e);
											} 
												
											
										}
									
									private static final String SELECT_QA_BY_ID="SELECT"
											+" o.id, o.ownerId, o.customerId, o.ownerQA, createTime , c.name, c2.name, answer "
											+" FROM vgb.ownerqas AS o JOIN vgb.customers AS c ON o.ownerId = c.id JOIN vgb.customers AS c2 ON o.customerId = c2.id "
											+ " WHERE o.id=? ";
													
											
									 OwnerQa selectOwner_QA_ById(int id) throws VGBException {
										 OwnerQa o = null;
										
										
										try (
											Connection connection =RDBConnection.getConnection();//1.2取得連線物件
											PreparedStatement pstmt =connection.prepareStatement(SELECT_QA_BY_ID);//3.準備指令
										){
											//3.1
											pstmt.setInt(1, id);
											
											//4.執行指令
											try(
													ResultSet rs= pstmt.executeQuery();
													){
														//5.處理rs
												while(rs.next()) {
													o=new OwnerQa();
													Customer Owner= new Customer();
													Customer Customer= new Customer();
													
													o.setId(rs.getInt("o.id"));
													o.setOwnerQA(rs.getString("o.ownerQA"));
													o.setCreateTime(rs.getString("createTime"));
													o.setAnswer(rs.getString("answer"));
													
													Owner.setId(rs.getString("o.ownerId"));
													Owner.setName(rs.getString("c.name"));
													o.setOwnerId(Owner);
													
													Customer.setId(rs.getString("o.customerId"));
													Customer.setName(rs.getString("c2.name"));
													o.setCustomerId(Customer);
														
												}
													}
												} catch (SQLException e) {
													throw new VGBException("用主鑑值查詢客戶失敗",e);		
												}
												 
												return o;
											}
}

