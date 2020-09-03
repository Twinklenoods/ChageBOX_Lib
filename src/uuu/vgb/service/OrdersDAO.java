package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import uuu.vgb.entity.Order;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;


public class OrdersDAO {
	private static final String INSERT_ORDER= " INSERT INTO `Orders` "
			+ "(`id`, `productID`, `uniprice`, `pay`, `use`, "
			+ "`name`, `phone`,`email`, `address`, `createTime`, `pay_fee`, `use_fee` ) \n" 
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
			pstmt.setString(10,o.getCreateTime());
			pstmt.setString(11,o.getPay_fee());
			pstmt.setString(12,o.getUse_fee());
		
			
		
			
			
			
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
	
	
}
