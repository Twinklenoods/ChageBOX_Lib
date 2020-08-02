package uuu.vgb.test;


import uuu.vgb.entity.Product;

public class TestProduct2 {

	public static void main(String[] args) {
		//System.out.println(args.length);
		
		
		
		
		Product p= new Product(2,"動物森友會",1300);		
		//Product p= new Product();
		//p.setId(1);
		//p.setName("動物森友會");
		//p.setUnitPrice(1300);
		p.setOrigin("台北");
	
		
		System.out.println(p.getName());
		System.out.println(p.getId());
		System.out.println(p.getUnitPrice());
	
		//System.out.println(p.getDescription());
		//System.out.println(p.getPhotoUrl());
		System.out.println(p.getOrigin());
		//System.out.println(p.getHost());
		//System.out.println(p.isUnsold());
	
	
	}
	

}
