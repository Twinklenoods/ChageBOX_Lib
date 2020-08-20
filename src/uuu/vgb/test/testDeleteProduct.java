package uuu.vgb.test;


import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.ProductService;
import uuu.vgb.entity.Customer;

public class testDeleteProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductService service =new ProductService();
		try {
			Product p = service.login("39", "A123456789");
				
				
				service.deleteProduct(p);
				
		}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
