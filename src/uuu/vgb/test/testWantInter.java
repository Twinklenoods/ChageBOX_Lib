package uuu.vgb.test;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.WantChange;
import uuu.vgb.service.OrderService;

public class testWantInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderService service =new OrderService();
		try {
			WantChange q=new WantChange();
			Product p = new Product();	
			Customer Q= new Customer();
			Customer Q2= new Customer();
			Order o =new Order();
			o.setId(15);
			o.setPay_fee(4);
			
		
			
				service.update(o);
				
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
