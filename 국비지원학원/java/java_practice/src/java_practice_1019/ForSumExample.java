package java_practice_1019;

import java.util.Scanner;

public class ForSumExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 >");
		int num = sc.nextInt();
		int sum = 0;
		int even = 0;
		int odd = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
			if (i%2 == 0) {
				even += i;
			}
			if (i%2 == 1) {
				odd += i;
			}
		}
		System.out.println("1부터 "+num+"까지의 총합계 : " + sum);
		System.out.println("1부터 "+num+"까지의 짝수의 총합계 : " + even);
		System.out.println("1부터 "+num+"까지의 홀수의 총합계 : " + odd);
		
	}

}
