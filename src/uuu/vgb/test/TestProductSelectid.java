package uuu.vgb.test;

import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductSelectService;
import uuu.vgb.service.ProductService;

public class TestProductSelectid {

	public static void main(String[] args) {
	ProductSelectService service =new ProductSelectService();
	
	try {
		System.out.println(service.getOwner("A123456789"));
		System.out.println("bye");
	}catch (VGBException e) {
		e.printStackTrace();
	}
		
	}
	
}
