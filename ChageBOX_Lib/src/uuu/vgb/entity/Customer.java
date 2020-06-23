package uuu.vgb.entity;

import java.time.LocalDate;

public class Customer {
	public String id; //required, PKey, ROC Id(natural key)
	public String name = ""; //required(必要)
	public String password;
	public char gender; //required(必要), 'M':男, 'F':女
	public String email; //required(必要),unique index
	public LocalDate birthday; //required(必要)需要import java.time.LocalDate, JDK 8開始才有這個類別
	public String address="";//optional(檢查是否不一樣)
	public String phone="";//optional(檢查是否不一樣)
	public boolean married;
	
	public int getAge() {
		int thisYear =LocalDate.now().getYear();
		//System.out.println(thisYear);
		
		int birthYear=this.birthday.getYear();
		int age =thisYear-birthYear;
		return age;
	}
	//public BloodType bloodType;//這個屬性將在第11章加入
	//public int status = 1; //0:新會員, 1:已啟用, -1:已停用。這個屬性課程中都用不到





}
