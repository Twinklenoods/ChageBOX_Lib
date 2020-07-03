package uuu.vgb.test;



import uuu.vgb.entity.Customer;

public class TestCustomerAge {

	public static void main(String[] args) {
		Customer cus = new Customer();
		cus.setId("A123123123");
		cus.setName("吳大頭");
		cus.setPassword("123456");
		cus.setGender('1');
		cus.setEmail("astrayx56408@gmail.com");
		//cus.birthday=LocalDate.of(1990,4,1);
		//cus.birthday=LocalDate.now();
		//cus.birthday=LocalDate.parse("1999-04-01");
		//cus.setBirthday(1999,1,4);
		//System.out.println(cus.getBirthday());
		//String bDate="2999-06-09";
		cus.setBirthday("2022-06-09");
		System.out.println(cus.getBirthday());
		
		cus.setPhone("0912294389");
		
		//for(int i= 1;i<=9;i++) {
			//for(int j=1;j<=i;j++) {
              //  System.out.print(j+"×"+i+"="+i*j+"\t");// \t 跳到下一个TAB位置
           // }}
		
		
		
		
		System.out.println(cus.getPhone());
		System.out.println("id="+cus.getId());
		System.out.println(cus.getName());
		System.out.println(cus.getPassword());
		System.out.println(cus.getGender());
		System.out.println(cus.getEmail());
		System.out.println(cus.getBirthday()!=null?
				cus.getBirthday().getDayOfWeek():"忘記輸入生日");
		System.out.println(cus.getBirthday());
		System.out.println(cus.getAddress());
		
		
		
		System.out.println(cus.getAge());
		
		
		
	}

}
