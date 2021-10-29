package test1029.number5;

import java.util.Scanner;

public class CharacterReadingExam {

	public static void main(String[] args) {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		String num = "1234567890";
		
		System.out.println("문자나 숫자를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		//코드 작성
		String chars1 = str.charAt(0)+"";
		String input = chars1.toLowerCase();
		
		System.out.println("입력받은 문자: "+chars1);
		System.out.println("영어문자 : "+chars.contains(input));
		System.out.println("숫자 : "+num.contains(input));
		sc.close();
	}

}
