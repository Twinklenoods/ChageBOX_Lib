package uuu.vgb.service;

import java.util.List;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
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

		
	public List<Question> getQuertionsByProductID(String productID)throws VGBException{
		return dao.selectQuertionsByProductID(productID);
		}
	}