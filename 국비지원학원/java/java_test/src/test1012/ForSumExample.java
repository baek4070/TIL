package test1012;

import java.util.Scanner;

public class ForSumExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요>");
		int maxNum = sc.nextInt();
		int sum= 0;
		int threeTotalSum = 0;
		for (int i = 1; i < maxNum+1; i++) {
			sum += i;
			if (i % 3 == 0) {
				threeTotalSum += i;
			}
		}
		System.out.println("1부터 "+maxNum+"까지의 총합계 : "+sum);
		System.out.println("1부터 "+maxNum+"까지의 3의 배수의 총합계 : "+threeTotalSum);
	}

}
