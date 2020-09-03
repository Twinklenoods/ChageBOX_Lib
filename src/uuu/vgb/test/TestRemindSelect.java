package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.OrderService;
import uuu.vgb.service.OwnerQaService;
import uuu.vgb.service.RemindService;


public class TestRemindSelect {

	public static void main(String[] args) {
	OrderService service =new OrderService();
	
	try {
		System.out.println(service.getOrderBuyByUserID("A123456789"));
		
		System.out.println("bye");
	}catch (VGBException e) {
		e.printStackTrace();
	}
		
	}
	
}
