package uuu.vgb.test;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.OwnerQa;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.OwnerQaService;
import uuu.vgb.service.QuestionService;

public class testOwnerQAInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OwnerQaService service =new OwnerQaService();
		try {
			OwnerQa q=new OwnerQa();
			
			Customer Q= new Customer();
			Customer Q2 =new Customer();
				
		
			Q2.setId("A123456761");
			q.setCustomerId(Q2);
			Q.setId("A123456789");
			q.setOwnerId(Q);
			
			
			q.setOwnerQA("急需");
		
			
				service.register(q);
				
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
