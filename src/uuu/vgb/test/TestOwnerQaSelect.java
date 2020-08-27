package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.OwnerQaService;


public class TestOwnerQaSelect {

	public static void main(String[] args) {
	OwnerQaService service =new OwnerQaService();
	
	try {
		System.out.println(service.getOwnerID("A123456761","A123456789"));
		
		System.out.println("bye");
	}catch (VGBException e) {
		e.printStackTrace();
	}
		
	}
	
}
