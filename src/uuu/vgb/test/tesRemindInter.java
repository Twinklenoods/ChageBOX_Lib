package uuu.vgb.test;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.remind;
import uuu.vgb.service.QuestionService;
import uuu.vgb.service.RemindService;

public class tesRemindInter{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemindService service =new RemindService();
		try {
			remind r=new remind();
			
				
			
			r.setUser("西往母");
			
		
			
				service.register(r);
				
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
