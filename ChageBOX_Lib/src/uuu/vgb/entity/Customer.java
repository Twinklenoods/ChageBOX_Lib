package uuu.vgb.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Customer {
	private String id; //required, PKey, ROC Id(natural key)
	private String name = ""; //required(必要)
	private String password;
	private char gender; //required(必要), 'M':男, 'F':女
	private String email; //required(必要),unique index
	private LocalDate birthday; //required(必要)需要import java.time.LocalDate, JDK 8開始才有這個類別
	private String address="";//optional(檢查是否不一樣)
	private String phone="";//optional(檢查是否不一樣)
	private boolean married;
	//public BloodType bloodType;//這個屬性將在第11章加入
	//public int status = 1; //0:新會員, 1:已啟用, -1:已停用。這個屬性課程中都用不到
	
	public String getId() {return id;}
	public void setId(String id) {
		if(cheakID(id)) {
		this.id=id;
		}else {System.out.println("身分證不正確");
			}
				}
	
	public LocalDate getBirthday() {
		return birthday;
		}
	private void setBirthday(LocalDate birthday) {
		if(birthday.isBefore(LocalDate.now())) {this.birthday=birthday;
		}else{System.out.println("客戶生日不得大於今天"+birthday);}
	}
	
	public void setBirthday(int year,int month,int day) {
		LocalDate bDate=LocalDate.of(year,month,day);
		this.birthday=bDate;
	}
	public void setBirthday(String dateString) {
		LocalDate bDate=LocalDate.parse(dateString);
	if(bDate.isBefore(LocalDate.now())) {this.birthday=bDate;}else{System.out.println("客戶生日不得大於今天"+dateString);}
	}
	
	
	
	
	public int getAge() {//todo用periode改寫
		if(getBirthday()!=null) {
		int thisYear =LocalDate.now().getYear();
		//System.out.println(thisYear);
		int birthYear=this.getBirthday().getYear();
		int age =thisYear-birthYear;
		return age;}else {return 0;}
			}
	
	public boolean cheakID(String id) {
		//Scanner scanner =new Scanner(System.in);//輸入ID
		//String id =scanner.next();
		//if id = regular.exoression("");
		int ans = 0;
		char Char01 = id.charAt(0);// 將第一個字母提出來
		
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
		String sao ="[A-Z][1-2][0-9]{8}$"; 
		
		int ans01 = ans % 10;
		
		if(id!=null&&ans01 == 0&& id.matches(sao)) {
			//System.out.println(id + "正確");
			return true ;
		}
//		else if (ans01 != 0||Char02!='1'||Char02!='2'||id.matches(sao1)) {
//		//System.out.println(id + "不正確");
//				return false;
//		}
		return false;
		
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		if(name!=null&&name.length()>0) {
		this.name = name;
	}else{System.out.println("需要客戶姓名");
		}
			}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email) {
		if(email!=null&&email.matches("/^.*@gmail\\.com$/")) {;
		this.email = email;
	}else{System.out.println("gmail輸入錯誤");}}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	

	









}
