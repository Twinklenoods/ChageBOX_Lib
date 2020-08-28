package uuu.vgb.test;


import uuu.vgb.entity.Customer;
import uuu.vgb.entity.OwnerQa;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.OwnerQaService;
import uuu.vgb.service.ProductService;
import uuu.vgb.entity.Customer;

public class testQA_UPDOWN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OwnerQaService service =new OwnerQaService();
		try {
			OwnerQa o= service.login(4,"A123456789");
				
				o.setAnswer("yes");
				service.updown(o);;
				
		}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
