package b.string.method;

import java.util.Scanner;

public class StringCaseExam {

	public static void main(String[] args) {
		String str1 = "Java Programming!";
		String str2 = "JAVA Programming!";
		System.out.println(str1.equals(str2));
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1);
		System.out.println(lowerStr2);
		System.out.println(lowerStr1.equals(lowerStr2));
		
		System.out.println(str1.toUpperCase());
		System.out.println(str2.toUpperCase());
		
		// trim() - 문자열의 좌우 공백을 제거
		String tel1 = "           02";
		String tel2 = "1234         ";
		String tel3 = "   1234      ";
		String tel4 = " 010 9486 7166  ";
		System.out.println(tel1.trim()+tel2.trim()+tel3.trim());
		System.out.println(tel4.trim());
		
		Scanner sc = new Scanner(System.in);
		String id = sc.next().trim();
		
		if(id.equals("id001")) {
			System.out.println("일치합니다.");
		}else {
			System.out.println("일치하지 않습니다.");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}

