package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;

public class testCustomerServiceLogin1 {

	public static void main(String[] args) {
		CustomerService service =new CustomerService();
		try {
		Customer c =service.login("A123456789","123456");
		System.out.println(c);
	}catch(VGBException e) {
	 e.printStackTrace();	
	}catch(Exception e) {
		 e.printStackTrace();
	}
		System.out.println("Bye");
	}

}
