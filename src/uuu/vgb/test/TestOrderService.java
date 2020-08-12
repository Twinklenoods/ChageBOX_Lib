package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.service.OrderService;

class TestOrderService {

	public static void main(String[] args) {
		Customer c= new Customer();
		c.setId("A123123123");
		c.setName("吳大頭");
		c.setPassword("123456");
		c.setGender('F');
		c.setEmail("astrayx56408@gmail.com");
		//cus.birthday=LocalDate.of(1990,4,1);
		 Outlet out= new Outlet();
		 out.setId(1010001);
		 out.setDiscount(0);
		 out.setUnitPrice(600);
		
		
		Product p=new Product(1,"遊戲",500);
		
		
		OrderService servicer =new OrderService();
				double amount1=servicer.order(c,p,2);
				double amount2=servicer.order(c,out,1);
	System.out.println("買方測試1:"+amount1);
	
	System.out.println("賣方測試2:"+amount2);
	System.out.println(out);
	}
	
	
}
