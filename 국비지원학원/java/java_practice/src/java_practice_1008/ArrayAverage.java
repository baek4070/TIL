package java_practice_1008;

import java.util.Scanner;

public class ArrayAverage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int scores[] = new int[5];
		//scores.length = 5
		//  0  1  2  3  4
		// [0][1][2][3][4]
		int sum = 0;
		double avrg;
		for (int i = 0; i < scores.length; i++) {
			System.out.print("성적을 입력하세요>");
			scores[i] = sc.nextInt();
			sum += scores[i];
		}
		avrg = sum/scores.length;
		// 출력 형태만 실수로 나오는건지 float 의 f 와 관련있는건지 ?
		// double type 을 f 로 print 해도 되는지?
//		System.out.printf("평균 성적은 %.2f 입니다",avrg);
		System.out.printf("평균 성적은 %.0f 입니다",avrg);
	}

}
