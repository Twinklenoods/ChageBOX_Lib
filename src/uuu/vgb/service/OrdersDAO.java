package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.WantChange;


public class OrdersDAO {
	private static final String INSERT_ORDER= " INSERT INTO `Orders` "
			+ "(`id`, `productID`, `uniprice`, `pay`, `use`, "
			+ "`name`, `phone`,`email`, `address`, `use_fee`, `userID`, `ownerID` ) \n" 
			+ "    VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			
	public void insert(Order o) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(INSERT_ORDER);//3.準備指令
		){
			//3.1傳入?值
			pstmt.setInt(1,o.getId());//3.1 自動
			pstmt.setInt(2,o.getProductID());
			pstmt.setInt(3,o.getUniprice());
			pstmt.setString(4,o.getPay());
			pstmt.setString(5,o.getUse());
			pstmt.setString(6,o.getName());
			pstmt.setString(7,o.getPhone());
			pstmt.setString(8,o.getEmail());
			pstmt.setString(9,o.getAddress());
			//pstmt.setString(10,o.getCreateTime());
			
			//pstmt.setString(10,o.getPay_fee());
			pstmt.setString(10,o.getUse_fee());
			pstmt.setString(11,o.getUserID());
			pstmt.setString(12,o.getOwnerID());
		
			
			
			
			 pstmt.executeUpdate();//4.執行指令
			
		} catch (SQLIntegrityConstraintViolationException e) {
			String key="";
			if(e.getMessage().indexOf("PRIMSRY")>=0) {
				key="id";
			}
			throw new VGBException("訂單已重複-"+key+"訂單重複註冊",e);
		} catch (SQLException e) {
				throw new VGBException("訂單新增失敗",e);
		} 
	}
	
	private static final String SELECT_BUY_BY_USERID="SELECT"
			+" id, productID, uniprice, pay, usec, name, phone, email, address, createTime, pay_fee, use_fee, userID, ownerID, proName "
			+" FROM orders "
			+ " WHERE userID =?";
		public  List<Order> selectOrderByUserID(String UserID) throws VGBException{
				List<Order> list =new ArrayList<>();
				try(
						Connection connection =RDBConnection.getConnection();//1.2取得連線物件
						PreparedStatement pstmt =connection.prepareStatement(SELECT_BUY_BY_USERID);//3.準備指令
						){
					//3.1塞植入ownerID
					pstmt.setString(1,UserID);
					//4.執行指令
					try(
							ResultSet rs= pstmt.executeQuery();
							){
						//5.處理rs
						while(rs.next()) {
							Order  o= new Order(); 
							
							o.setId(rs.getInt("id"));o.setAddress(rs.getString("address"));
							o.setProductID(rs.getInt("productID"));o.setCreateTime(rs.getString("createTime"));
							o.setUniprice(rs.getInt("uniprice"));o.setPay_fee(rs.getInt("pay_fee"));
							o.setPay(rs.getString("pay"));o.setUse_fee(rs.getString("use_fee"));
							o.setUse(rs.getString("usec"));o.setUserID(rs.getString("userID"));
							o.setName(rs.getString("name"));o.setOwnerID(rs.getString("ownerID"));
							o.setPhone(rs.getString("phone"));o.setProName(rs.getString("proName"));
							o.setEmail(rs.getString("email"));
							
						
							
							list.add(o);
								
						}
						
					}
				} catch (SQLException e) {

					
					throw new VGBException("用編號查詢失敗",e);		
				}
				 
				return list;
			}
	
}
