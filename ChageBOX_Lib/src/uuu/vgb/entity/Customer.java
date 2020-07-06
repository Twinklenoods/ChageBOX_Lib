package uuu.vgb.entity;

import java.time.LocalDate;


public class Customer {
	
	public static char MALE='M';
	public static char FEMALE='F';
	public static String GMAIL="^.*@gmail\\.com$";
	
	private String id; //required, PKey, ROC Id(natural key)
	private String name = ""; //required(必要)
	private String password;
	private char gender; //required(必要), 'M':男, 'F':女
	private String email; //required(必要),unique index
	private LocalDate birthday; //required(必要)需要import java.time.LocalDate, JDK 8開始才有這個類別
	private String address="";//optional(檢查是否不一樣)
	private String phone="";//optional(檢查是否不一樣)
	private boolean married;
	private BloodType bloodType;//這個屬性將在第11章加入
	//public int status = 1; //0:新會員, 1:已啟用, -1:已停用。這個屬性課程中都用不到
	
	public BloodType getBloodType() {
		return bloodType;
	}
	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}
	public String getId() {
		return id;
		}
	
	public void setId(String id) {
		if(cheakID(id)) {
		this.id=id;
		}else {System.out.println("身分證不正確");
			}
				}
	
	public LocalDate getBirthday() {
		return birthday;
		}
	public void setBirthday(LocalDate birthday) {
		if(birthday.isBefore(LocalDate.now())){ 
			
			this.birthday=birthday;
		}else{System.out.println("生日不得小於今天"+birthday);}
	}
	
	public void setBirthday(int year,int month,int day) {
		LocalDate bDate=LocalDate.of(year,month,day);
		this.birthday=bDate;	
	}
	public void setBirthday(String dateString) {
		LocalDate bDate=LocalDate.parse(dateString);
	this.birthday=bDate;
	}
	
	public int getAge() {//todo用periode改寫
		if(getBirthday()!=null) {
		int thisYear =LocalDate.now().getYear();
	
		int birthYear=this.getBirthday().getYear();
		int age =thisYear-birthYear;
		return age;}else {return 0;}
			}
	private static final String sao ="[A-Z][1-2][0-9]{8}$";
	public static boolean cheakID(String id) {
		
		int ans = 0;
		 
		int ans01 = ans % 10;
		if(id!=null&&ans01 == 0&& id.matches(sao)) {
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
		
		
		
		
		
		
			return true ;
		}	
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
		if(password!=null&&password.length()>=6&&password.length()<20) {
			this.password = password;
		}else{System.out.println("需要輸入6-20的密碼");
			}
	}
	public char getGender() {
		
		return gender;
	}
	public void setGender(char gender) {
		if(gender==MALE||gender==FEMALE) {
		this.gender = gender;
	}else {
			System.out.println("性別不正確('M'-男,'F'-女)"+gender);
		}
			}
	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email) {
		if(email!=null&&email.matches(GMAIL)) {
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
		if(phone!=null&&password.length()>=6) {
		this.phone = phone;
	}else {System.out.println("請輸入正確的電話號碼"+phone);
			}
				}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	
	public Customer() {}
	public Customer(String id,String pwd,LocalDate birthday) {
		this.setId(id);
		this.setPassword(pwd);
		this.setBirthday(birthday);
	}
	@Override
	public String toString() {
		 return this.getClass().getSimpleName()+
				"id=" + id +"\n"+ 
				" 名子=" + name +"\n"+ 
				" password=" + password +"\n"+ 
				" gender=" + gender + "\n"+
				" email="+ email + "\n"+
				" birthday=" + birthday +"\n"+ 
				" address=" + address + "\n"+
				" phone=" + phone + "\n"+
				" married="+ married ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			//if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	






}
