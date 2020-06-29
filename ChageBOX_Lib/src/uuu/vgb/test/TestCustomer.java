package uuu.vgb.test;



import uuu.vgb.entity.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		Customer cus = new Customer();
		cus.setId("A123456789");
		cus.setName("吳大頭");
		cus.setPassword("123456");
		cus.setGender('M');
		cus.setEmail("astrayx56408@gmail.com");
		//cus.setbirthday=LocalDate.of(1990,4,1);
		String bDate= "1999-06-09";
		cus.setBirthday(bDate);
		System.out.println(cus.getBirthday());
		
		//cus.birthday=LocalDate.now();
		//cus.birthday=LocalDate.parse("1990-04-01");
		cus.setPhone("0912294389");
		System.out.println(cus.getPhone());
		System.out.println(cus.getId());
		System.out.println(cus.getName());
		System.out.println(cus.getPassword());
		System.out.println(cus.getGender());
		System.out.println(cus.getEmail());
		System.out.println(cus.getBirthday()!=null?
				cus.getBirthday().getDayOfWeek():"");
		boolean a =(cus.cheakID(cus.getId()));
		
		System.out.println(a?cus.getId()+"正確":cus.getId()+"不正確");//boolean?true:false
		System.out.println(a); 
		System.out.println("id"+cus.cheakID(cus.getId()));
		System.out.println(cus.getBirthday());
		System.out.println(cus.getAddress());
	}

}
