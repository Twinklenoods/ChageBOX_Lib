package uuu.vgb.test;


import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.entity.Customer;

public class testCustomerUPDATE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService service =new CustomerService();
		try {
			Customer c = service.login("A123456761", "123456");	
				
				c.setName("西王母");
				c.setBirthday("1990-04-01");
				c.setGender(("FEMALE").charAt(0));
				c.setEmail("tes66442@gmail.com");
				
				service.update(c);
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
