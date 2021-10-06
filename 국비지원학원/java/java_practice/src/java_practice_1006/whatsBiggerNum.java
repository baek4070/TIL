package java_practice_1006;

import java.util.Scanner;

public class whatsBiggerNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 : ");
		int firstNum = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int secondNum = sc.nextInt();
		if (firstNum > secondNum) {
			System.out.println("큰수는 : "+firstNum);
		}else if (firstNum < secondNum) {
			System.out.println("큰수는 : " + secondNum);
		}else {
			System.out.println("같거나 오류발생");
		}
	}
}
