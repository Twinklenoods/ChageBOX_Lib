package uuu.vgb.test;

import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductSelectService;
import uuu.vgb.service.ProductService;
import uuu.vgb.service.QuestionService;
import uuu.vgb.service.WantChangeService;

public class TestQusetionSelect {

	public static void main(String[] args) {
		WantChangeService service =new WantChangeService();
	
	try {
		System.out.println(service.getWantChangeByUserID("A123456789"));
		System.out.println("bye");
	}catch (VGBException e) {
		e.printStackTrace();
	}
		
	}
	
}
