package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.OwnerQa;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.remind;

public class RemindDAO {
	private static final String INSERT_REMIND=" INSERT INTO `reminds` (`remindId`, `lookTime`, `user`, `unlook`, `owner`) \n" 
			+ "    VALUES(?,?,?,?,?)";

	public void insert(remind r) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(INSERT_REMIND);//3.準備指令
		){
			//3.1傳入?值
			pstmt.setInt(1,r.getRemindId());//3.1 自動
			pstmt.setString(2,r.getLookTime());
			pstmt.setString(3,r.getUser());
			pstmt.setBoolean(4,r.isUnLook());
			pstmt.setString(5,r.getOwner().getId());
			
			
			
			 pstmt.executeUpdate();//4.執行指令
			
		} catch (SQLIntegrityConstraintViolationException e) {
			String key="";
			if(e.getMessage().indexOf("PRIMSRY")>=0) {
				key="id";
			}
			throw new VGBException("提醒已重複-"+key+"提醒複註冊",e);
		} catch (SQLException e) {
				throw new VGBException("提醒新增失敗",e);
		} 
	}
	
	private static final String UPDATE_REMIND=" UPDATE reminds"
			+" SET unlook=?"
			+" WHERE remindId=?";
 
 public void update(remind c) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(UPDATE_REMIND);//3.準備指令
		){
			//3.1傳入?值
			//3.1
			pstmt.setBoolean(1,c.isUnLook());
			
			pstmt.setInt(2,c.getRemindId());
		
			
			 pstmt.executeUpdate();//4.執行指令
			
		} catch (SQLIntegrityConstraintViolationException e) {
			String key="";
			
			throw new VGBException("商品修改已重複-"+key+"商品重複註冊",e);
		} catch (SQLException e) {
				throw new VGBException("客戶修改失敗",e);
		} 
			
		
	}
 
	private static final String SELECT_REMIND = "SELECT"
			+ " remindId, lookTime, user, unlook, owner, customers.name" 
			+ "	FROM reminds LEFT JOIN customers ON customers.id=reminds.user "
			+" WHERE owner LIKE ? AND lookTime IS NULL order by remindId desc";
	public  List<remind> searctRemindByOwner(String ownerID) throws VGBException{
		List<remind> list =new ArrayList<>();
		try(
		Connection connection =RDBConnection.getConnection();//1.2
		PreparedStatement pstmt =connection.prepareStatement(SELECT_REMIND);//3
		){
			//3.1傳入
			pstmt.setString(1, '%'+ownerID+'%');
			//4.執行指令
			try(
			ResultSet rs =pstmt.executeQuery();
			){
				while(rs.next()) {
					remind r = new remind();
					Customer owner =new Customer(); 
					r.setOwner(owner);
					owner.setName(rs.getString("customers.name"));
					owner.setId(rs.getString("owner"));
					r.setRemindId(rs.getInt("remindId"));
					r.setLookTime(rs.getString("lookTime"));
					r.setUser(rs.getString("user"));
					r.setUnLook(rs.getBoolean("unlook"));
				
					list.add(r);
					
					
					
					
					
				}
				
				
				
			}
			
		}catch(SQLException e) {
			throw new VGBException("[用關鍵字查詢失敗]",e);
			
			
		}
		
		return list;
	}
 }