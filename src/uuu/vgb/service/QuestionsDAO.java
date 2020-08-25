package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
}
