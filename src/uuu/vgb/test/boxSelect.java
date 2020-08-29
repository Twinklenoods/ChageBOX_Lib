package uuu.vgb.test;

import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductSelectService;
import uuu.vgb.service.ProductService;
import uuu.vgb.service.QuestionService;

public class boxSelect {

	public static void main(String[] args) {
	ProductSelectService service =new ProductSelectService();
	
	try {
		System.out.println(service.getBOX("yes"));
		System.out.println("bye");
	}catch (VGBException e) {
		e.printStackTrace();
	}
		
	}
	
}
