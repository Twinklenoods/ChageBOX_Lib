package uuu.vgb.test;

import uuu.vgb.entity.Product;
import uuu.vgb.entity.ShoppingCart;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductSelectService;
import uuu.vgb.service.ProductService;

public class testcart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductSelectService service=new ProductSelectService();
		try {
			ShoppingCart cart =new ShoppingCart();
			Product p1 =service.getProduct("6");
			Product p2 =service.getProduct("1");
			cart.add(p1);
			cart.add(p2);
			System.out.println(cart.getCart());
		}catch (VGBException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
