package uuu.vgb.service;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import uuu.vgb.entity.VGBException;


class RDBConnection {
	private final static String driver ="com.mysql.cj.jdbc.Driver";
	private final static String url="jdbc:mysql://localhost:3306/vgb?serverTimezone=UTC";//characterEncoding=utf8
	private final static String user="root";
	private final static String password="6408";
	
	public static Connection getConnection() throws VGBException{
		try {
			Class.forName(driver);//1.載入Driver
			
			try {
				Connection  connection =DriverManager.getConnection(url,user,password);//2.建立連線
				return connection;
			} catch (SQLException e) {
				//System.out.println("建立連線失敗");
				throw new VGBException("建立連線失敗",e);
				
			}
		} catch (ClassNotFoundException e) {
			//System.out.println("載入Drive失敗");
			throw new VGBException("載入Drive失敗",e);
			
			
			
			//e.printStackTrace();
		}
		//return null;//是不恰當的寫法
	}
	public static void main(String[] args) {
		
		try(
				Connection con = RDBConnection.getConnection();
		){
			
				System.out.println(con.getCatalog());
			} catch (SQLException e) {				
				e.printStackTrace();
			}catch(VGBException e){
				System.out.println("非預期錯誤"+e);
			}
		}
	} 


