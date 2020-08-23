package uuu.vgb.test;


import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.ProductService;
import uuu.vgb.entity.Customer;

public class testproductUPDOWN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductService service =new ProductService();
		try {
			Product p = service.login("64", "A123456789");
				
				p.setUpdown("yes");
				service.updown(p);
				
		}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
