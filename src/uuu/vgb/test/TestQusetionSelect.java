package uuu.vgb.test;

import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductSelectService;
import uuu.vgb.service.ProductService;
import uuu.vgb.service.QuestionService;

public class TestQusetionSelect {

	public static void main(String[] args) {
	QuestionService service =new QuestionService();
	
	try {
		System.out.println(service.getQuertionsByProductID("1"));
		System.out.println("bye");
	}catch (VGBException e) {
		e.printStackTrace();
	}
		
	}
	
}
