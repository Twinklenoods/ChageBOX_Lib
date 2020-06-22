package uuu.vgb.entity;

import java.time.LocalDate;

public class Customer {
	public String id; //required, PKey, ROC Id
	public String name = ""; //required(必要)
	public String password;
	public char gender; //required(必要), 'M':男, 'F':女
	public String email; //required(必要)
	public LocalDate birthday; //required(必要)需要import java.time.LocalDate, JDK 8開始才有這個類別
	public String address;//optional(檢查是否不一樣)
	public String phone;//optional(檢查是否不一樣)
	public boolean married;
	//public BloodType bloodType;//這個屬性將在第11章加入
	//public int status = 1; //0:新會員, 1:已啟用, -1:已停用。這個屬性課程中都用不到





}
