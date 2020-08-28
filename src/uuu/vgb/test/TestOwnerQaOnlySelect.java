package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.OwnerQaService;


public class TestOwnerQaOnlySelect {

	public static void main(String[] args) {
	OwnerQaService service =new OwnerQaService();
	
	try {
		System.out.println(service.getOwnerIdOnly("A123456761"));
		
		System.out.println("bye");
	}catch (VGBException e) {
		e.printStackTrace();
	}
		
	}
	
}
