package uuu.vgb.test;

import java.time.LocalDate;

import uuu.vgb.entity.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		Customer cus = new Customer();
		cus.id ="A123456789";
		cus.name="吳大頭";
		cus.password="123456";
		cus.gender='M';
		cus.email="astrayx56408@gmail.com";
		cus.birthday=LocalDate.of(1990,4,1);
		//cus.birthday=LocalDate.now();
		//cus.birthday=LocalDate.parse("1990-04-01");
		cus.phone="0912294389";
		System.out.println(cus.phone);
		System.out.println(cus.id);
		System.out.println(cus.name);
		System.out.println(cus.password);
		System.out.println(cus.gender);
		System.out.println(cus.email);
		System.out.println(cus.birthday!=null?
				cus.birthday.getDayOfWeek():"忘記輸入生日");
		System.out.println("id"+cus.cheakID(cus.id));
		System.out.println(cus.birthday);
		System.out.println(cus.address);
	}

}
