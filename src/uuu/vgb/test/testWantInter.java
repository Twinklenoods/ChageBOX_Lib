package uuu.vgb.test;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.WantChange;
import uuu.vgb.service.QuestionService;
import uuu.vgb.service.WantChangeService;

public class testWantInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WantChangeService service =new WantChangeService();
		try {
			WantChange q=new WantChange();
			Product p = new Product();	
			Customer Q= new Customer();
			Customer Q2= new Customer();
				
			p.setId(1);
			q.setProductID(p);
				
			Q.setId("A123456789");
			q.setUser(Q);
			
			Q2.setId("A123456761");
			q.setOwnerID(Q2);
		
		
			
				service.register(q);
				
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
