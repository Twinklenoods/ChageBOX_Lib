package uuu.vgb.test;


import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.ProductService;
import uuu.vgb.entity.Customer;

public class testproductUPDATE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductService service =new ProductService();
		try {
			Product p = service.login("58", "A129067964");
				
				p.setName("修改名子2");
				p.setUnitPrice(1200);
				p.setDescription("01");			
				p.setWantChange("test02");
				
				p.setPhotoUrl("img");			
				p.setOrigin("usa");
				p.setHost("ps4");
				p.setBuy("yes");
				p.setChangebox("yes");
				
				service.update(p);
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
