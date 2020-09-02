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
import uuu.vgb.entity.WantChange;
import uuu.vgb.entity.remind;

public class WantChangeDAO {
	private static final String INSERT_WANTCHANGE= "   INSERT INTO `changes` (`changesID`, `productID`, `user`, `cheack`, `ownerID`) \n" 
			+ "    VALUES(?,?,?,?,?)";
			
	public void insert(WantChange W) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(INSERT_WANTCHANGE);//3.準備指令
		){
			//3.1傳入?值
			
			pstmt.setInt(1,W.getChangesID());//3.1 自動
			
			pstmt.setInt(2,W.getProductID().getId());
			pstmt.setString(3,W.getUser().getId());
			pstmt.setInt(4,W.getCheack());
			pstmt.setString(5,W.getOwnerID().getId());
			
			
			
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
	
	private static final String SELECT_CHANGE_BY_OWNERID="SELECT"
			+" w.changesID, w.productID, w.user, w.cheack, w.ownerID, c.name, c2.name,p.name, p.photoUrl"
			+" FROM vgb.changes AS w "
			+ "JOIN vgb.customers AS c ON w.user = c.id "
			+ "JOIN vgb.customers AS c2 ON w.ownerID = c2.id "
			+ "JOIN vgb.products AS p ON w.productID = p.id  "
			+ "WHERE w.ownerId =?";
			
			public  List<WantChange> selectOwnerChangeByID(String ownerID) throws VGBException{
				List<WantChange> list =new ArrayList<>();
				
				
				try(
						Connection connection =RDBConnection.getConnection();//1.2取得連線物件
						PreparedStatement pstmt =connection.prepareStatement(SELECT_CHANGE_BY_OWNERID);//3.準備指令
						){
					//3.1塞植入ownerID
					pstmt.setString(1,ownerID);
					
					//4.執行指令
					try(
							ResultSet rs= pstmt.executeQuery();
							){
						//5.處理rs
						while(rs.next()) {
							WantChange w=new WantChange();
							Customer user= new Customer();
							Customer owner= new Customer();
							Product productID =new Product();
							
							w.setChangesID(rs.getInt("w.changesID"));
							w.setCheack(rs.getInt("w.cheack"));
							
							productID.setId(rs.getInt("w.productID"));
							productID.setName(rs.getString("p.name"));
							productID.setPhotoUrl(rs.getString("p.photoUrl"));
							w.setProductID(productID);
							
							user.setId(rs.getString("w.user"));
							user.setName(rs.getString("c.name"));
							w.setUser(owner);
							
							owner.setId(rs.getString("w.ownerID"));
							owner.setName(rs.getString("c2.name"));
							w.setUser(user);
							
						
							
							list.add(w);
								
						}
						
					}
				} catch (SQLException e) {

					
					throw new VGBException("用編號查詢失敗",e);		
				}
				 
				return list;
			}
	
	
			private static final String UPDATE_CHANGE=" UPDATE changes"
					+" SET cheack=?"
					+" WHERE changesID=?";
		 
		 public void update(WantChange w) throws VGBException{
				
				try (
					Connection connection =RDBConnection.getConnection();//1.2.取得連線
					PreparedStatement pstmt =connection.prepareStatement(UPDATE_CHANGE);//3.準備指令
				){
					//3.1傳入?值
					//3.1
					
					
					pstmt.setInt(1,w.getCheack());
					pstmt.setInt(2,w.getChangesID());
					
					 pstmt.executeUpdate();//4.執行指令
					
				} catch (SQLIntegrityConstraintViolationException e) {
					String key="";
					
					throw new VGBException("商品修改已重複-"+key+"商品重複註冊",e);
				} catch (SQLException e) {
						throw new VGBException("客戶修改失敗",e);
				} 
					
				
			}

		 private static final String SELECT_CHANGE_BY_USER="SELECT"
					+" w.changesID, w.productID, w.user, w.cheack, w.ownerID, c.name, c2.name, p.name, p.photoUrl "
					+" FROM vgb.changes AS w "
					+ "JOIN vgb.customers AS c ON w.user = c.id "
					+ "JOIN vgb.customers AS c2 ON w.ownerID = c2.id "
					+ "JOIN vgb.products AS p ON w.productID = p.id  "
					+ "WHERE w.user =?";
					
					public  List<WantChange> selectUserChangeByID(String userID) throws VGBException{
						List<WantChange> list =new ArrayList<>();
						
						
						try(
								Connection connection =RDBConnection.getConnection();//1.2取得連線物件
								PreparedStatement pstmt =connection.prepareStatement(SELECT_CHANGE_BY_USER);//3.準備指令
								){
							//3.1塞植入ownerID
							pstmt.setString(1,userID);
							
							//4.執行指令
							try(
									ResultSet rs= pstmt.executeQuery();
									){
								//5.處理rs
								while(rs.next()) {
									WantChange w=new WantChange();
									Customer user= new Customer();
									Customer owner= new Customer();
									Product productID =new Product();
									
									w.setChangesID(rs.getInt("w.changesID"));
									w.setCheack(rs.getInt("w.cheack"));
									
									productID.setId(rs.getInt("w.productID"));
									productID.setName(rs.getString("p.name"));
									productID.setPhotoUrl(rs.getString("p.photoUrl"));
									w.setProductID(productID);
									
									user.setId(rs.getString("w.user"));
									user.setName(rs.getString("c.name"));
									w.setUser(user);
									
									owner.setId(rs.getString("w.ownerID"));
									owner.setName(rs.getString("c2.name"));
									w.setUser(owner);
									
								
									
									list.add(w);
										
								}
								
							}
						} catch (SQLException e) {

							
							throw new VGBException("用編號查詢失敗",e);		
						}
						 
						return list;
					}
		
	}
