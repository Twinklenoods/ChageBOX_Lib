package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;

public class QuestionService {
	QuestionsDAO dao =new QuestionsDAO();
	public void register(Question q) throws VGBException{
		if(q==null) {
			throw new IllegalArgumentException("問題q不能等於null");
		}
		dao.insert(q);
	} 
//	public Question login(String questionId,String productId )throws VGBException{
//		
//		if(questionId==null||productId==null) {
//			throw new IllegalArgumentException("問答沒有導入");
//		}
//		Question q=null;
//		c=dao.selectCustomersById(id);
		
		
//		if(c!=null) {
//			if(pwd.equals(c.getPassword())) {
//			return c;
//			}
			
			
//		}
//			throw new VGBException("目前密碼輸入錯誤");
		
	}