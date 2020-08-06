package uuu.vgb.test;


import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.entity.Customer;

public class testCustomerInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService service =new CustomerService();
		try {
			Customer c = new Customer();	
				c.setId("A145679854");	
				c.setName("vu1");
				c.setBirthday("2005-05-05");
				c.setPassword("123456");
				c.setGender(("MALE").charAt(0));
				c.setEmail("test000111100112@gmail.com");
				
				service.register(c);
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
