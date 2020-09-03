package uuu.vgb.test;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;

import uuu.vgb.service.QuestionService;
import uuu.vgb.service.OrderService;
public class testQuertionsInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderService service =new OrderService();
		try {
			
			Order o =new Order(); 
		
			o.setProductID(1);
			o.setAddress("1231");
			o.setEmail("2313213");
			
				
			service.register(o);
				
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
