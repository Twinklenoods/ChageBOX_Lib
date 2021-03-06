package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
class ProductsDAO {
	

	private static final String INSERT_PRODUCT= "   INSERT INTO `products` (`id`, `name`, `owner`, `customer`, `unitprice`, `description`, `wantChange`,`photoUrl`, `origin`, `host`, `buy`, `changebox`, `ownerN`) \n" 
			+ "    VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
	public void insert(Product c) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(INSERT_PRODUCT);//3.準備指令
		){
			//3.1傳入?值
			pstmt.setInt(1,c.getId());//3.1
			pstmt.setString(2,c.getName());
			pstmt.setString(3,c.getOwner().getId());
			pstmt.setString(4,c.getCustomer());			
			pstmt.setDouble(5,c.getUnitPrice());
			pstmt.setString(6,c.getDescription());			
			pstmt.setString(7,c.getWantChange());
			pstmt.setString(8,c.getPhotoUrl());
			pstmt.setString(9,c.getOrigin());
			pstmt.setString(10,c.getHost());
			pstmt.setString(11,c.getBuy());
			pstmt.setString(12,c.getChangebox());
			pstmt.setString(13,c.getOwner().getName());//取得customer的name
			
			
			 pstmt.executeUpdate();//4.執行指令
			
		} catch (SQLIntegrityConstraintViolationException e) {
			String key="";
			if(e.getMessage().indexOf("PRIMSRY")>=0) {
				key="id";
			}
			throw new VGBException("商品已重複-"+key+"重複註冊",e);
		} catch (SQLException e) {
				throw new VGBException("客戶新增失敗",e);
		} 
			
		
	}


	private static final String SELECT_PRODUCT_BY_ID="SELECT"
			+ " products.id,products.name,description,origin,customers.id,changebox,customers.name,host,unitprice,createTime,buy,wantChange,photoUrl,customer" 
			+ "	FROM products LEFT JOIN customers ON customers.id=products.owner"
					+ " WHERE products.id=?";
			
	Product selectProductsById(String id) throws VGBException {
		Product c = null;
		
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2取得連線物件
			PreparedStatement pstmt =connection.prepareStatement(SELECT_PRODUCT_BY_ID);//3.準備指令
		){
			//3.1
			pstmt.setString(1, id);
			
			//4.執行指令
			try(
					ResultSet rs= pstmt.executeQuery();
					){
						//5.處理rs
				while(rs.next()) {
						c=new Product();
						Customer owner= new Customer();
						
						c.setName(rs.getString("name"));
						owner.setName(rs.getString("customers.name"));
						owner.setId(rs.getString("customers.id"));
						
						c.setCustomer(rs.getString("customer"));
						c.setId(rs.getInt("id"));
						c.setUnitPrice(rs.getDouble("UnitPrice"));
						
						c.setDescription(rs.getString("Description"));			
						c.setWantChange(rs.getString("WantChange"));
						c.setPhotoUrl(rs.getString("PhotoUrl"));
						c.setOrigin(rs.getString("Origin"));
						c.setHost(rs.getString("Host"));
						c.setBuy(rs.getString("Buy"));
						c.setChangebox(rs.getString("Changebox"));
						//c.setOwnerN(rs.getString("ownerN"));
						c.setOwner(owner);
						
						
				}
					}
				} catch (SQLException e) {
					throw new VGBException("用產品編號查詢失敗",e);		
				}
				 
				return c;
			}
	private static final String UPDATE_PRODUCT=" UPDATE products"
			+" SET name=?,unitprice=?,description=?, wantChange=?, photoUrl=?, origin=?, host=?, buy=?, changebox=? "
			+" WHERE id=?";
 
 public void update(Product p) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(UPDATE_PRODUCT);//3.準備指令
		){
			//3.1傳入?值
			//3.1
			pstmt.setString(1,p.getName());
			pstmt.setDouble(2,p.getUnitPrice());
			pstmt.setString(3,p.getDescription());			
			pstmt.setString(4,p.getWantChange());
			
			pstmt.setString(5,p.getPhotoUrl());			
			pstmt.setString(6,p.getOrigin());
			pstmt.setString(7,p.getHost());
			pstmt.setString(8,p.getBuy());
			pstmt.setString(9,p.getChangebox());
			//pstmt.setString(10,p.getOwner().getId());
			pstmt.setInt(10,p.getId());
			pstmt.executeUpdate();//4.執行指令
			
		} catch (SQLIntegrityConstraintViolationException e) {
			String key="";
			if(e.getMessage().indexOf("email_UNIQUE")>=0) {
				key="email";
			}else if(e.getMessage().indexOf("PRIMSRY")>=0) {
				key="id";
			}
			throw new VGBException("商品修改已重複-"+key+"商品重複註冊",e);
		} catch (SQLException e) {
				throw new VGBException("客戶修改失敗",e);
		} 
			
		
	}
 
 private static final String UPDATE_UPDOWN=" UPDATE products"
			+" SET updown=?, owner=?"
			+" WHERE id=?";

public void updown(Product p) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(UPDATE_UPDOWN);//3.準備指令
		){
			//3.1傳入?值
			//3.1
			pstmt.setString(1,p.getUpdown());
			pstmt.setString(2,p.getOwner().getId());
			
			pstmt.setInt(3,p.getId());
			pstmt.executeUpdate();//4.執行指令
			
		} catch (SQLIntegrityConstraintViolationException e) {
			String key="";
			
			throw new VGBException("商品修改已重複-"+key+"商品重複註冊",e);
		} catch (SQLException e) {
				throw new VGBException("客戶修改失敗",e);
		} 
			
		
	}

private static final String DELETE_PROUCST=" DELETE FROM products"
		
		+" WHERE id=?";

public void deleteProduct(Product p) throws VGBException{
	
	try (
		Connection connection =RDBConnection.getConnection();//1.2.取得連線
		PreparedStatement pstmt =connection.prepareStatement(DELETE_PROUCST);//3.準備指令
	){
		//3.1傳入?值
		//3.1
	
		
		pstmt.setInt(1,p.getId());
		pstmt.executeUpdate();//4.執行指令
		
	} catch (SQLIntegrityConstraintViolationException e) {
		String key="";
		
		throw new VGBException("商品已刪除-"+key+"已無商品可以刪除",e);
	} catch (SQLException e) {
			throw new VGBException("客戶刪除失敗",e);
	} 
		
	
}
 
private static final String UPDATE_BUY=" UPDATE products"
		+" SET customer=?"
		+" WHERE id=?";

public void updownBUY(Product p) throws VGBException{
	
	try (
		Connection connection =RDBConnection.getConnection();//1.2.取得連線
		PreparedStatement pstmt =connection.prepareStatement(UPDATE_BUY);//3.準備指令
	){
		//3.1傳入?值
		//3.1
		pstmt.setString(1,p.getCustomer());
		
		
		pstmt.setInt(2,p.getId());
		pstmt.executeUpdate();//4.執行指令
		
	} catch (SQLIntegrityConstraintViolationException e) {
		String key="";
		
		throw new VGBException("商品修改已重複-"+key+"商品重複註冊",e);
	} catch (SQLException e) {
			throw new VGBException("客戶修改失敗",e);
	} 
		
	
}
 
private static final String UPDATE_LISTRATING=" UPDATE products"
		+" SET listrating=?"
		+" WHERE id=?";

public void listrating(Product p) throws VGBException{
	
	try (
		Connection connection =RDBConnection.getConnection();//1.2.取得連線
		PreparedStatement pstmt =connection.prepareStatement(UPDATE_LISTRATING);//3.準備指令
	){
		//3.1傳入?值
		//3.1
		pstmt.setInt(1,p.getListrating());
		pstmt.setInt(2,p.getId());
		
		pstmt.executeUpdate();//4.執行指令
		
	} catch (SQLIntegrityConstraintViolationException e) {
		String key="";
		
		throw new VGBException("商品修改已重複-"+key+"商品重複註冊",e);
	} catch (SQLException e) {
			throw new VGBException("客戶修改失敗",e);
	} 
		
	
}
 
		}
