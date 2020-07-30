package uuu.vgb.entity;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


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
		if(checkId(id)) {
		this.id=id;
		}else {
			//System.out.println("身分證不正確");
			throw new DataInvalidException("身分證不正確");
		}
				}
	
	public LocalDate getBirthday() {
		return birthday;
		}
	public void setBirthday(LocalDate birthday) {
		if(birthday.isBefore(LocalDate.now())){ 
			
			this.birthday=birthday;
		}else{
			//System.out.println("生日不得小於今天"+birthday);
			throw new DataInvalidException("生日不得小於今天"+birthday);
		}
	}
	
	public void setBirthday(int year,int month,int day) {
		LocalDate bDate=LocalDate.of(year,month,day);
		this.birthday=bDate;	
	}
	public void setBirthday(String dateString) {
	try {
		LocalDate bDate=LocalDate.parse(dateString);
		this.birthday=bDate;
	}catch(DateTimeParseException ex) {
		throw new DataInvalidException("客戶格式不正確");
		}
	}
	
	public int getAge() {//todo用periode改寫
		if(getBirthday()!=null) {
		int thisYear =LocalDate.now().getYear();
	
		int birthYear=this.getBirthday().getYear();
		int age =thisYear-birthYear;
		return age;}else {return 0;}
			}
	public static String idPattern = "[A-Z][12][0-9]{8}";
	public boolean checkId(String id){
		//商業邏輯開始
		if (id!=null && id.matches(idPattern)) { // 用regular expression檢查id字串格式
			char firstChar = id.charAt(0);
			
			// 1. 將第1個英文字母(A-Z)轉成對應的數字
			int firstNum = 0;
			if (firstChar >= 'A' && firstChar <= 'H') {
				firstNum = (int)firstChar - 'A' + 10;
			} else if (firstChar >= 'J' && firstChar <= 'N') {
				firstNum = (int)firstChar - 'J' + 18;
			} else if (firstChar >= 'P' && firstChar <= 'V') {
				firstNum = (int)firstChar - 'J' + 23;
			} else { 
//			
				
				switch(firstChar) {
				default:
					return false;					
				case 'O':
					firstNum = 35;
					break;
				case 'I':
						firstNum = 34;
						break;
				case 'X':
					firstNum = 30;
					break;
				case 'Y':
					firstNum = 31;
					break;
				case 'W':
						firstNum = 32;
						break;
				case 'Z':
						firstNum = 33;
						break;
				}				
			}
			
			System.out.println(firstChar +"->"+firstNum);
		
			int sum = firstNum/10 + firstNum%10*9;			
			
			for(int i=1;i<=8;i++) {
				sum = sum + ((id.charAt(i)-'0') * (9-i));
				
			}
			
			
			sum = sum + ((id.charAt(9)-'0') * 1);
			
			if(sum%10 == 0) {
				
				return true;
			}
		}
		
		
		return false;
		
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		if(name!=null&&name.length()>0) {
		this.name = name;
	}else{
		
		throw new DataInvalidException("需要客戶姓名");
		}
			}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password!=null&&password.length()>=6&&password.length()<20) {
			this.password = password;
		}else{
			
			throw new DataInvalidException("需要輸入6-20的密碼");
			}
	}
	public char getGender() {
		
		return gender;
	}
	public void setGender(char gender) {
		if(gender==MALE||gender==FEMALE) {
		this.gender = gender;
	}else {
			
			throw new DataInvalidException("性別不正確('M'-男,'F'-女)"+gender);
		}
			}
	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email) {
		if(email!=null&&email.matches(GMAIL)) {
		this.email = email;
	}else{
	throw new DataInvalidException("gmail輸入錯誤");
	}}
			
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
	}else {
			throw new DataInvalidException("請輸入正確的電話號碼"+phone);
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
