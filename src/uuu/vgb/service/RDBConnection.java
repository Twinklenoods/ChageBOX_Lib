package uuu.vgb.service;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


class RDBConnection {
	private final static String driver ="com.mysql.cj.jdbc.Driver";
	private final static String url="jdbc:mysql://localhost:3306/vgb?serverTimezone=UTC";
	private final static String user="root";
	private final static String password="6408";
	
	public static Connection getConnection() {
		try {
			Class.forName(driver);//1.載入Driver
			
			try {
				Connection  connection =DriverManager.getConnection(url,user,password);//2.建立連線
				return connection;
			} catch (SQLException e) {
				System.out.println("建立連線失敗");
				//TODO :要throw Exception
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("載入Drive失敗");
			//e.printStackTrace();
		}
		return null;//是不恰當的寫法
	}
	public static void main(String[] args) {
		
		try(
				Connection con = RDBConnection.getConnection();
		){
			
				System.out.println(con.getCatalog());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 

