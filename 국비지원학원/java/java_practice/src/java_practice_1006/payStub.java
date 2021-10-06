package java_practice_1006;

import java.util.Scanner;

public class payStub {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사원명을 입력하세요?");
		String name = sc.next();
		System.out.println("시급을 입력하세요?");
		int wage = sc.nextInt();
		System.out.println("근무시간을 입력하세요?");
		int workingHour = sc.nextInt();
		System.out.println("급여명세서");
		System.out.println("사원명:"+name);
		int pay = wage*workingHour;
		System.out.println("급여금액:"+(pay)+"원");
		int tax = wage*workingHour*3/100;
		System.out.println("공제합계:"+(tax)+"원");
		System.out.println("실지급액:"+(pay-tax)+"원");
	}

}
