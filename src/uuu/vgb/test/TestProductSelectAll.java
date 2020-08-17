package uuu.vgb.test;

import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductSelectService;
import uuu.vgb.service.ProductService;

public class TestProductSelectAll {

	public static void main(String[] args) {
	ProductSelectService service =new ProductSelectService();
	
	try {
		System.out.println(service.getAllProducts()
				);
	}catch (VGBException e) {
		e.printStackTrace();
	}
		
	}
	
}
