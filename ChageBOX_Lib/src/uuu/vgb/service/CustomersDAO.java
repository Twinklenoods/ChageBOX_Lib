package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
class CustomersDAO {
	
	
	private static final String INSERT_CUSTOMER= "   insert INTO customers" + 
			"(id, name,password,gender,email,birthday,"
			+ "address,phone,married)"
			+ 
			"    VALUES(?,?,?,?,?,?,?,?,?)";
	public void insert(Customer c) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(INSERT_CUSTOMER);//3.準備指令
		){
			//3.1傳入?值
			pstmt.setString(1,c.getId());//3.1
			pstmt.setString(2,c.getName());
			pstmt.setString(3,c.getPassword());
			pstmt.setString(4,String.valueOf(c.getGender()));			
			pstmt.setString(5,c.getEmail());
			pstmt.setString(6,c.getBirthday().toString());			
			pstmt.setString(7,c.getPhone());
			pstmt.setString(8,c.getAddress());
			pstmt.setBoolean(9,c.isMarried());
			
			 pstmt.executeUpdate();//4.執行指令
			
		} catch (SQLIntegrityConstraintViolationException e) {
			String key="";
			if(e.getMessage().indexOf("email_UNIQUE")>=0) {
				key="email";
			}else if(e.getMessage().indexOf("PRIMSRY")>=0) {
				key="id";
			}
			throw new VGBException("帳號已重複-"+key+"重複註冊",e);
		} catch (SQLException e) {
				throw new VGBException("客戶新增失敗",e);
		} 
			
		
	}


	private static final String SELECT_CUSTOMER_BY_ID="SELECT  id, name, password, gender, email, address, birthday,phone,"
			+ "married,discount, class_name FROM vgb.customers"
			+" WHERE id=?";
	 Customer selectCustomersById(String id) throws VGBException {
		Customer c = null;
		
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2取得連線物件
			PreparedStatement pstmt =connection.prepareStatement(SELECT_CUSTOMER_BY_ID);//3.準備指令
		){
			//3.1
			pstmt.setString(1, id);
			
			//4.執行指令
			try(
					ResultSet rs= pstmt.executeQuery();
					){
						//5.處理rs
				while(rs.next()) {
						c=new Customer();
						
						c.setId(rs.getString("id"));
						c.setName(rs.getString("name"));
						c.setPassword(rs.getString("password"));
						c.setGender(rs.getString("gender").charAt(0));
						c.setEmail(rs.getString("email"));
						c.setBirthday(rs.getString("birthday"));
						
				}
					}
				} catch (SQLException e) {
					throw new VGBException("用主鑑值查詢客戶失敗",e);		
				}
				 
				return c;
			}

		}
