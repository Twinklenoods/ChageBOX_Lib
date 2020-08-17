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
	
	//, createTime
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
			pstmt.setString(3,c.getOwner());
			pstmt.setString(4,c.getCustomer());			
			pstmt.setDouble(5,c.getUnitPrice());
			pstmt.setString(6,c.getDescription());			
			pstmt.setString(7,c.getWantChange());
			pstmt.setString(8,c.getPhotoUrl());
			pstmt.setString(9,c.getOrigin());
			pstmt.setString(10,c.getHost());
			pstmt.setString(11,c.getBuy());
			pstmt.setString(12,c.getChangebox());
			pstmt.setString(13,c.getOwnerN());
			
			
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


	private static final String SELECT_PRODUCT_BY_ID=
			"id, name, owner, customer, unitprice, description, wantChange, photoUrl,\"\n" + 
			"			+ \"origin, host, buy, changebox, createTime FROM products" //);
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
						
						
						
						
				}
					}
				} catch (SQLException e) {
					throw new VGBException("用主鑑值查詢客戶失敗",e);		
				}
				 
				return c;
			}
	/* private static final String UPDATE_CUSTOMER=" UPDATE customers"
				+" SET name=?,password=?,gender=?, email=?, birthday=?, address=?, phone=?"
				+" WHERE id=?";
	 
	 public void update(Customer c) throws VGBException{
			
			try (
				Connection connection =RDBConnection.getConnection();//1.2.取得連線
				PreparedStatement pstmt =connection.prepareStatement(UPDATE_CUSTOMER);//3.準備指令
			){
				//3.1傳入?值
				//3.1
				pstmt.setString(1,c.getName());
				pstmt.setString(2,c.getPassword());
				pstmt.setString(3,String.valueOf(c.getGender()));			
				pstmt.setString(4,c.getEmail());
				pstmt.setString(5,c.getBirthday().toString());			
				pstmt.setString(6,c.getAddress());
				pstmt.setString(7,c.getPhone());
				pstmt.setString(8,c.getId());
				//pstmt.setBoolean(9,c.isMarried());
				
				 pstmt.executeUpdate();//4.執行指令
				
			} catch (SQLIntegrityConstraintViolationException e) {
				String key="";
				if(e.getMessage().indexOf("email_UNIQUE")>=0) {
					key="email";
				}else if(e.getMessage().indexOf("PRIMSRY")>=0) {
					key="id";
				}
				throw new VGBException("修改已重複-"+key+"重複註冊",e);
			} catch (SQLException e) {
					throw new VGBException("客戶修改失敗",e);
			} 
			
			
		}*/
		}
