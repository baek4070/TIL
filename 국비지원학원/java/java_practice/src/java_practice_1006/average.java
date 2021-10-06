package java_practice_1006;

import java.util.Scanner;

public class average {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성적을 입력하시오:");
		int sum = sc.nextInt();
		System.out.print("성적을 입력하시오:");
		sum = sum + sc.nextInt();
		System.out.print("성적을 입력하시오:");
		sum = sum + sc.nextInt();
		System.out.print("성적을 입력하시오:");
		sum = sum + sc.nextInt();
		System.out.print("성적을 입력하시오:");
		sum = sum + sc.nextInt();
		System.out.println("평균 성적은"+(sum/5)+"입니다");
	}
}
