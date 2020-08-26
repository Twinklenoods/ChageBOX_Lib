package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;

public class QuestionsDAO {
	
	
	private static final String INSERT_QUESTION= "   INSERT INTO `questions` (`questionId`, `productId`, `user`, `QA`) \n" 
			+ "    VALUES(?,?,?,?)";
			
	public void insert(Question q) throws VGBException{
		
		try (
			Connection connection =RDBConnection.getConnection();//1.2.取得連線
			PreparedStatement pstmt =connection.prepareStatement(INSERT_QUESTION);//3.準備指令
		){
			//3.1傳入?值
			pstmt.setInt(1,q.getQuestionId());//3.1 自動
			pstmt.setInt(2,q.getProductId().getId());
			pstmt.setString(3,q.getUser().getId());
			pstmt.setString(4,q.getQuestion());
		
			
			
			
			 pstmt.executeUpdate();//4.執行指令
			
		} catch (SQLIntegrityConstraintViolationException e) {
			String key="";
			if(e.getMessage().indexOf("PRIMSRY")>=0) {
				key="id";
			}
			throw new VGBException("問答已重複-"+key+"問答重複註冊",e);
		} catch (SQLException e) {
				throw new VGBException("問答新增失敗",e);
		} 
	}
	private static final String SELECT_QUERTION_BY_PRODUCTID="SELECT"
	+" questions.questionId, questions.productId, user, QA, questions.createTime, customers.name,products.name"
	+" FROM vgb.questions LEFT JOIN customers ON customers.id=questions.user LEFT JOIN products ON products.id=questions.productId"
	+ " WHERE productId=?";
	
	public  List<Question> selectQuertionsByProductID(String productID) throws VGBException{
		List<Question> list =new ArrayList<>();
		
		
		try(
				Connection connection =RDBConnection.getConnection();//1.2取得連線物件
				PreparedStatement pstmt =connection.prepareStatement(SELECT_QUERTION_BY_PRODUCTID);//3.準備指令
				){
			//3.1塞植入productId
			pstmt.setString(1, productID);
			//4.執行指令
			try(
					ResultSet rs= pstmt.executeQuery();
					){
				//5.處理rs
				while(rs.next()) {
					Question q=new Question();
					Customer user= new Customer();
					Product productId=new Product();
					
					q.setQuestionId(rs.getInt("questions.questionId"));
					productId.setId(rs.getInt("productId"));
					user.setId(rs.getString("user"));
					
					q.setQuestion(rs.getString("QA"));
					q.setCreateTime(rs.getString("questions.createTime"));
					user.setName(rs.getString("customers.name"));
					productId.setName(rs.getString("products.name"));
					
					q.setUser(user);
					q.setProductId(productId);
					
					list.add(q);
										
						
							
				}
				
			}
		} catch (SQLException e) {

			
			throw new VGBException("用編號查詢失敗",e);		
		}
		 
		return list;
	}

}
