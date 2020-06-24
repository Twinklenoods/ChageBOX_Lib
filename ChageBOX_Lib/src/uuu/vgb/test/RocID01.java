package uuu.vgb.test;
import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class RocID01 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);//輸入ID
		String id =scanner.next();
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
		
		// 公式
		ans = (first1-48)*1 +(first2-48)*9+ (Char02 - 48) * 8 + (Char03 - 48) * 7 + (Char04 - 48) * 6 + (Char05 - 48) * 5
				+ (Char06 - 48) * 4 + (Char07 - 48) * 3 + (Char08 - 48) * 2 + (Char09 - 48) * 1 + (Char10 - 48) * 1;
		String sao ="[A-Z&&[^a-z]][1-2][0-9]{8}$"; 
		String sao1 ="[^a-z]";
		int ans01 = ans % 10;
		
		if (ans01 == 0&& id.matches(sao)&&(id.length()==10)) {
			System.out.println(id + "正確");
			return;
		} else if (ans01 != 0||Char02!='1'||Char02!='2'||id.matches(sao1)) {
		System.out.println(id + "不正確");

		}
		
	}

}
