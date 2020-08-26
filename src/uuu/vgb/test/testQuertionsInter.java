package uuu.vgb.test;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;

import uuu.vgb.service.QuestionService;

public class testQuertionsInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuestionService service =new QuestionService();
		try {
			Question q=new Question();
			Product p = new Product();	
			Customer Q= new Customer();
			
				
			p.setId(1);
			q.setProductId(p);
				
			Q.setId("A123456789");
			q.setUser(Q);
			
			
			q.setQuestion("急需");
		
			
				service.register(q);
				
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
