package uuu.vgb.test;

import uuu.vgb.entity.Customer;

public class TestEqualsTo {

	public static void main(String[] args) {
		int i =1;
		double j=1;
		System.out.println(i==j);//true
		
		Customer c1 =new Customer();
		c1.id="A123456789";
		
		Customer c2 =new Customer();
		c2.id="A123456789";
		
		System.out.println(c1==c2);//false 因為不同物件
		c1=c2;//其原本c1的new Customer 變成多餘的
		System.out.println(c1==c2);//12行的Customer c1 =new Customer(); 變成garbage
		
	
	
	
	}

}
