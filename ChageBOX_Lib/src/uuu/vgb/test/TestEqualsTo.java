package uuu.vgb.test;


import uuu.vgb.entity.Customer;

public class TestEqualsTo {

	public static void main(String[] args) {
		int i =1;
		double j=1;
		System.out.println(i==j);//true
		
		Customer c1 =new Customer();
		c1.setId("A123456789");
		
		Customer c2 =new Customer();
		c2.setId("A123456789");
		
		System.out.println(c1==c2);//false 因為不同物件
		int sum=0;
		for(int f =1;f<=10;f++) {
			sum=sum+f;
			//sum+=f;
		}
		
	
		System.out.println(true+(1+"你好"));
		System.out.printf("答案是: %b%d%s",true,1,"你好"+"\n");
		
		
		c1=c2;//其原本c1的new Customer 變成多餘的
		System.out.println(c1==c2);//12行的Customer c1 =new Customer(); 變成garbage
		System.out.println(32<<2);
		System.out.println(-32>>2);
	int q =100;
		for( q =1;q<=9;q++) {
		for(int w =1;w<=q;w++) {
			System.out.println(q+"*"+w+"="+q*w+"\t");
		}
		}
	}
	
	
	}


