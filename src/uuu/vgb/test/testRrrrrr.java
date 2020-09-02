package uuu.vgb.test;


import uuu.vgb.entity.Customer;
import uuu.vgb.entity.OwnerQa;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.WantChange;
import uuu.vgb.entity.remind;
import uuu.vgb.service.CustomerService;
import uuu.vgb.service.OwnerQaService;
import uuu.vgb.service.ProductService;
import uuu.vgb.service.RemindService;
import uuu.vgb.service.WantChangeService;
import uuu.vgb.entity.Customer;

public class testRrrrrr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WantChangeService service =new WantChangeService();
		try {
			remind r = new remind();
			Customer c = new Customer();
			WantChange w= new WantChange();
			
			//c.setId("A123456789");
			//r.setQ_owner(c);
			
			w.setChangesID(3);
			w.setCheack(2);
			//r.setQ_owner(c2);
			//r.setC_owner(c3);	
			service.update(w);
				
		}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
