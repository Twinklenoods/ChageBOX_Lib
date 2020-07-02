package uuu.vgb.test;


import uuu.vgb.entity.Product;

public class TestProduct {

	public static void main(String[] args) {
		//System.out.println(args.length);
		int i =1;
		int j =i;
		
		
		
		Product p= new Product();		
		p.setId(1);
		p.setName("動物森友會");
		p.setUnitPrice(1300);
		p.setOrigin("台北");
		p.setStock(2);
		p.setHost('P');
		//System.out.println(p.getName());
		//System.out.println(p.getId());
		//System.out.println(p.getUnitPrice());
		//System.out.println(p.getStock());
		//System.out.println(p.getDescription());
		//System.out.println(p.getPhotoUrl());
		//System.out.println(p.getOrigin());
		//System.out.println(p.getHost());
		//System.out.println(p.isUnsold());
	System.out.println("p:"+p.toString());
	
	}
	

}
