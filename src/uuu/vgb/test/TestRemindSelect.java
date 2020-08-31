package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.OwnerQaService;
import uuu.vgb.service.RemindService;


public class TestRemindSelect {

	public static void main(String[] args) {
	RemindService service =new RemindService();
	
	try {
		System.out.println(service.getRemind("A123456761"));
		
		System.out.println("bye");
	}catch (VGBException e) {
		e.printStackTrace();
	}
		
	}
	
}
