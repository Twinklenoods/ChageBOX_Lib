package uuu.vgb.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;

class ProductsSelectDAO {

	private static final String SELECT_ALL_PRODUCTS="SELECT"
			+ " id,name,description,origin,ownerN,owner,host,unitprice,createTime,buy,wantChange,photoUrl,customer" 
			+ "	FROM products";
			
	List<Product> selectAllProducts() throws VGBException{
		List<Product> list =new ArrayList<>();
		
		
		try (Connection conn =RDBConnection.getConnection();
				Statement stmt =conn.createStatement();//.3建立指令
				ResultSet rs= stmt.executeQuery(SELECT_ALL_PRODUCTS);
				){
			while(rs.next()) {
//				String className =rs.getString("class_name");
//				int discount = rs.getInt("discount");
//				Product p;
//				if("Outlet".equals(className)||discount>0) {
//					p = new Outlet();
//					(()p).setDiscount(discount);
//				}else{
//					p=new Product();
//				}
				
				Product p = new Product();
				
			
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setUnitPrice(rs.getDouble("unitprice"));
				p.setOwner(rs.getString("owner"));
				p.setDescription(rs.getString("Description"));			
				p.setWantChange(rs.getString("WantChange"));
				p.setPhotoUrl(rs.getString("PhotoUrl"));
				p.setOrigin(rs.getString("Origin"));
				p.setHost(rs.getString("Host"));
				p.setOwnerN(rs.getString("ownerN"));
				
				list.add(p);
			}
	
		
		}catch(SQLException e) {
			throw new VGBException("查詢全部產品失敗",e);
		}
		return list;
		
	}
	
	private static final String SELECT_PRODUCT_BY_ID="SELECT"
			+ " id,name,description,origin,ownerN,changebox,owner,host,unitprice,createTime,buy,wantChange,photoUrl,customer" 
			+ "	FROM products"
					+ " WHERE id=?";
			
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
						c.setName(rs.getString("name"));
						c.setOwner(rs.getString("owner"));
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
						c.setOwnerN(rs.getString("ownerN"));
						
						
						
				}
					}
				} catch (SQLException e) {
					throw new VGBException("用產品編號查詢失敗",e);		
				}
				 
				return c;
			}

}
