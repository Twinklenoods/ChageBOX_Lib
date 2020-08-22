package uuu.vgb.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;

class ProductsSelectDAO {

	private Logger LOG = Logger.getLogger(ProductsSelectDAO.class.getName());
	private static final String SELECT_ALL_PRODUCTS="SELECT"
			+ " id,name,description,origin,ownerN,owner,host,unitprice,createTime,buy,wantChange,photoUrl,customer" 
			+ "	FROM products";
			
	List<Product> selectAllProducts() throws VGBException{
		List<Product> list =new ArrayList<>();
		

		LOG.info("selectAllProducts");
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

				LOG.info(p.toString());
			}
	
		
		}catch(SQLException e) {
			throw new VGBException("查詢全部產品失敗",e);
		}
		return list;
		
	}
	
	private static final String SELECT_PRODUCT_BY_ID="SELECT"
			+ " products.id,products.name,description,origin,customers.id,changebox,customers.name,host,unitprice,createTime,buy,wantChange,photoUrl,customer" 
			+ "	FROM products LEFT JOIN customers ON customers.id=products.owner"
					+ " WHERE products.id=?";
			
	Product selectProductsById(String id) throws VGBException {
		Product c = null;

		LOG.info("selectProductsById");
		
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
						LOG.info("有東西！");
						
				}
					}
				} catch (SQLException e) {

					LOG.info(e.toString());
					throw new VGBException("用產品編號查詢失敗",e);		
				}
				 
				return c;
			}


	private static final String SELECT_PRODUYS_BY_OWNER = "SELECT"
			+ " id,name,description,origin,ownerN,changebox,owner,host,unitprice,createTime,buy,wantChange,photoUrl,customer,updown" 
			+ "	FROM products"
					+ " WHERE owner LIKE ? AND updown='no'";
	public  List<Product> searchProductsByname(String owner) throws VGBException{
		List<Product> list =new ArrayList<>();
		try(
		Connection connection =RDBConnection.getConnection();//1.2
		PreparedStatement pstmt =connection.prepareStatement(SELECT_PRODUYS_BY_NAME);//3
		){
			//3.1傳入
			pstmt.setString(1, '%'+owner+'%');
			//4.執行指令
			try(
			ResultSet rs =pstmt.executeQuery();
			){
				while(rs.next()) {
					Product p = new Product();
					p.setName(rs.getString("name"));
					p.setOwner(rs.getString("owner"));
					p.setCustomer(rs.getString("customer"));
					p.setId(rs.getInt("id"));
					p.setUnitPrice(rs.getDouble("UnitPrice"));
					p.setDescription(rs.getString("Description"));			
					p.setWantChange(rs.getString("WantChange"));
					p.setPhotoUrl(rs.getString("PhotoUrl"));
					p.setOrigin(rs.getString("Origin"));
					p.setHost(rs.getString("Host"));
					p.setBuy(rs.getString("Buy"));
					p.setChangebox(rs.getString("Changebox"));
					p.setOwnerN(rs.getString("ownerN"));
					
					list.add(p);
					
					
					
					
					
				}
				
				
				
			}
			
		}catch(SQLException e) {
			throw new VGBException("[用關鍵字查詢失敗]",e);
			
			
		}
		
		return list;
	}
	private static final String SELECT_PRODUYS_BY_NAME="SELECT"
			+ " id,name,description,origin,ownerN,changebox,owner,host,unitprice,createTime,buy,wantChange,photoUrl,customer" 
			+ "	FROM products"
			+ " WHERE name LIKE ? AND updown='yes'";
			
	public  List<Product> selectProductsByOwner(String search) throws VGBException{
		List<Product> list =new ArrayList<>();
		try(
				Connection connection =RDBConnection.getConnection();//1.2
				PreparedStatement pstmt =connection.prepareStatement(SELECT_PRODUYS_BY_OWNER);//3
				){
			//3.1傳入
			pstmt.setString(1, '%'+search+'%');
			//4.執行指令
			try(
					ResultSet rs =pstmt.executeQuery();
			){
				while(rs.next()) {
					Product p = new Product();
					p.setName(rs.getString("name"));
					p.setOwner(rs.getString("owner"));
					p.setCustomer(rs.getString("customer"));
					p.setId(rs.getInt("id"));
					p.setUnitPrice(rs.getDouble("UnitPrice"));
					p.setDescription(rs.getString("Description"));			
					p.setWantChange(rs.getString("WantChange"));
					p.setPhotoUrl(rs.getString("PhotoUrl"));
					p.setOrigin(rs.getString("Origin"));
					p.setHost(rs.getString("Host"));
					p.setBuy(rs.getString("Buy"));
					p.setChangebox(rs.getString("Changebox"));
					p.setOwnerN(rs.getString("ownerN"));
					p.setCreateTime(rs.getString("createTime"));
					list.add(p);
					
					
					
					
					
				}
				
				
				
			}
			
		}catch(SQLException e) {
			throw new VGBException("[用關鍵字查詢失敗]",e);
			
			
		}
		
		return list;
	}

	private static final String SELECT_PRODUYS_BY_UPDOWN="SELECT"
			+ " id,name,description,origin,ownerN,changebox,owner,host,unitprice,createTime,buy,wantChange,photoUrl,customer,updown" 
			+ "	FROM products"
			+ " WHERE updown LIKE ? AND customer IS NULL order by createTime desc";
			
	public  List<Product> selectProductsUpdown(String updown) throws VGBException{
		List<Product> list =new ArrayList<>();

		LOG.info("selectProductsUpdown");
		try(
				Connection connection =RDBConnection.getConnection();//1.2
				PreparedStatement pstmt =connection.prepareStatement(SELECT_PRODUYS_BY_UPDOWN);//3
				){
			//3.1傳入
			pstmt.setString(1, '%'+updown+'%');
			//4.執行指令
			try(
					ResultSet rs =pstmt.executeQuery();
			){
				while(rs.next()) {
					Product p = new Product();
					p.setName(rs.getString("name"));
					p.setOwner(rs.getString("owner"));
					p.setCustomer(rs.getString("customer"));
					p.setId(rs.getInt("id"));
					p.setUnitPrice(rs.getDouble("UnitPrice"));
					p.setDescription(rs.getString("Description"));			
					p.setWantChange(rs.getString("WantChange"));
					p.setPhotoUrl(rs.getString("PhotoUrl"));
					p.setOrigin(rs.getString("Origin"));
					p.setHost(rs.getString("Host"));
					p.setBuy(rs.getString("Buy"));
					p.setChangebox(rs.getString("Changebox"));
					p.setOwnerN(rs.getString("ownerN"));
					p.setCreateTime(rs.getString("createTime"));
					p.setUpdown(rs.getString("updown"));
					list.add(p);
					
				
					
					
				}
				
				
				
			}
			
		}catch(SQLException e) {
			throw new VGBException("[用關鍵字查詢失敗]",e);
			
			
		}
		
		return list;
	}
	
	private static final String SELECT_PRODUYS_BY_UPOWNER = "SELECT"
			+ " id,name,description,origin,ownerN,changebox,owner,host,unitprice,createTime,buy,wantChange,photoUrl,customer,updown" 
			+ "	FROM products"
					+ " WHERE owner LIKE ? AND updown='yes' order by owner desc";
	public  List<Product> selectProductsUpOwner(String search) throws VGBException{
		List<Product> list =new ArrayList<>();
		try(
				Connection connection =RDBConnection.getConnection();//1.2
				PreparedStatement pstmt =connection.prepareStatement(SELECT_PRODUYS_BY_UPOWNER);//3
				){
			//3.1傳入
			pstmt.setString(1, '%'+search+'%');
			//4.執行指令
			try(
					ResultSet rs =pstmt.executeQuery();
			){
				while(rs.next()) {
					Product p = new Product();
					p.setName(rs.getString("name"));
					p.setOwner(rs.getString("owner"));
					p.setCustomer(rs.getString("customer"));
					p.setId(rs.getInt("id"));
					p.setUnitPrice(rs.getDouble("UnitPrice"));
					p.setDescription(rs.getString("Description"));			
					p.setWantChange(rs.getString("WantChange"));
					p.setPhotoUrl(rs.getString("PhotoUrl"));
					p.setOrigin(rs.getString("Origin"));
					p.setHost(rs.getString("Host"));
					p.setBuy(rs.getString("Buy"));
					p.setChangebox(rs.getString("Changebox"));
					p.setOwnerN(rs.getString("ownerN"));
					p.setCreateTime(rs.getString("createTime"));
					list.add(p);
					
					
					
					
					
				}
				
				
				
			}
			
		}catch(SQLException e) {
			throw new VGBException("[用關鍵字查詢失敗]",e);
			
			
		}
		
		return list;
	}
	
}
