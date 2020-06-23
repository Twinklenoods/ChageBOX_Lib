package uuu.vgb.test;


import uuu.vgb.entity.Product;

public class TestProduct {

	public static void main(String[] args) {
		System.out.println(args.length);
		int i =1;
		int j =i;
		
		
		
		Product p= new Product();		
		p.id=1;
		p.name="動物森友會";
		p.unitPrice=1300;
		p.origin="台北";
		p.stock=2;
		
		System.out.println(p.name);
		System.out.println(p.id);
		System.out.println(p.unitPrice);
		System.out.println(p.stock);
		System.out.println(p.description);
		System.out.println(p.photoUrl);
		System.out.println(p.origin);
		System.out.println(p.host);
		System.out.println(p.unsold);
	
	
	}
	

}
