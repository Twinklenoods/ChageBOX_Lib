package uuu.vgb.entity;

import java.time.LocalDate;
import java.util.Scanner;

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
	//public BloodType bloodType;//這個屬性將在第11章加入
	//public int status = 1; //0:新會員, 1:已啟用, -1:已停用。這個屬性課程中都用不到
	public void setBirthday(int year,int month,int day) {
		this.birthday=LocalDate.of(year,month,day);
		
	}
	public void setBirthday(String dateString) {
		this.birthday=LocalDate.parse(dateString);
	}
	
	
	
	
	public int getAge() {//todo用periode改寫
		if(birthday!=null) {
		int thisYear =LocalDate.now().getYear();
		//System.out.println(thisYear);
		int birthYear=this.birthday.getYear();
		int age =thisYear-birthYear;
		return age;}else {return 0;}
			}
	
	public boolean cheakID(String id) {
		//Scanner scanner =new Scanner(System.in);//輸入ID
		//String id =scanner.next();
		//if id = regular.exoression("");
		int ans = 0;
		char Char01 = id.charAt(0);// 將第一個字母提出來
		char Char02 = id.charAt(1);
		char Char03 = id.charAt(2);
		char Char04 = id.charAt(3);
		char Char05 = id.charAt(4);
		char Char06 = id.charAt(5);
		char Char07 = id.charAt(6);
		char Char08 = id.charAt(7);
		char Char09 = id.charAt(8);
		char Char10 = id.charAt(9);
		
		String CharA ="";
		if (Char01 == 'A'){
			CharA ="10";
			}
		if (Char01 == 'B') {CharA = "11";}
		if (Char01 == 'C') {CharA = "12";}
		if (Char01 == 'D') {CharA = "13";}
		if (Char01 == 'E') {CharA = "14";}
		if (Char01 == 'F') {CharA = "15";}
		if (Char01 == 'G') {CharA = "16";}
		if (Char01 == 'H') {CharA = "17";}
		if (Char01 == 'I') {CharA = "34";}
		if (Char01 == 'J') {CharA = "18";}
		if (Char01 == 'K') {CharA = "19";}
		if (Char01 == 'L') {CharA = "20";}
		if (Char01 == 'M') {CharA = "21";}
		if (Char01 == 'N') {CharA = "22";}
		if (Char01 == 'O') {CharA = "35";}
		if (Char01 == 'P') {CharA = "23";}
		if (Char01 == 'Q') {CharA = "24";}
		if (Char01 == 'R') {CharA = "25";}
		if (Char01 == 'S') {CharA = "26";}
		if (Char01 == 'T') {CharA = "27";}
		if (Char01 == 'U') {CharA = "28";}
		if (Char01 == 'V') {CharA = "29";}
		if (Char01 == 'X') {CharA = "30";}
		if (Char01 == 'Y') {CharA = "31";}

		int first1=CharA.charAt(0);
		int first2=CharA.charAt(1);
		
		
		int sum =(first1-'0')+(first2-'0')*9;
		// 公式
		for (int i = 1;i<=8;i++) {
			sum=sum+(id.charAt(i)-'0')*(9-i);}
		
		ans = sum+ (Char10- 48) * 1;
		String sao ="[A-Z&&[^a-z]][1-2][0-9]{8}$"; 
		String sao1 ="[^a-z]";
		int ans01 = ans % 10;
		
		if(id!=null&&ans01 == 0&& id.matches(sao)&&(id.length()==10)) {
			//System.out.println(id + "正確");
			return true;
		}
//		else if (ans01 != 0||Char02!='1'||Char02!='2'||id.matches(sao1)) {
//		//System.out.println(id + "不正確");
//				return false;
//		}
		return false;
		
	}

	









}
