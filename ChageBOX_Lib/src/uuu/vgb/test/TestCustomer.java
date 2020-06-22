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
		cus.birthday=LocalDate.of(1990,04,01);
		System.out.println(cus.id);
		System.out.println(cus.name);
		System.out.println(cus.password);
		System.out.println(cus.gender);
		System.out.println(cus.email);
		System.out.println(cus.birthday.getDayOfWeek());
		System.out.println(cus.name);
		
	}

}
