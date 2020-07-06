package uuu.vgb.test;



import java.time.LocalDate;

import uuu.vgb.entity.BloodType;
import uuu.vgb.entity.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		Customer cus = new Customer("A1023456789","123456",LocalDate.parse("2022-01-04"));
		
		cus.setBloodType(BloodType.O);
		
		//Customer cus = new Customer();
		//cus.setId("A123456789");
		cus.setName("吳大頭");
		//cus.setPassword("123456");
		cus.setGender('M');
		cus.setEmail("astrayx56408@gmail.com");
		//cus.setBirthday=LocalDate.of(1990,4,1);
		//cus.setBirthday(LocalDate.parse("19900404"));
		//String bDate= "2999-06-09";
		//cus.setBirthday("2999-06-09");
		System.err.println(cus.getBloodType());
		System.out.println(cus.getBirthday());
		System.err.println(cus.getBloodType().name());
		System.err.println(cus.getBloodType().ordinal());
		
		//cus.birthday=LocalDate.now();
		//cus.birthday=LocalDate.parse("1990-04-01");
		cus.setPhone("0228910991");
		System.out.println(cus.getPhone());
		System.out.println(cus.getId());
		System.out.println(cus.getName());
		System.out.println(cus.getPassword());
		System.out.println(cus.getGender());
		System.out.println(cus.getEmail());
		System.out.println(cus.getBirthday()!=null?
				cus.getBirthday().getDayOfWeek():"");
		//boolean a =(cus.cheakID(cus.getId()));
		
		//System.out.println(a?cus.getId()+"正確":cus.getId()+"不正確");//boolean?true:false
		//System.out.println(a); 
		
		System.out.println(cus.getBirthday());
		System.out.println(cus.getAddress());
	}

}
