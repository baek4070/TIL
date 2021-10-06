package java_practice_1006;

import java.util.Scanner;

public class Circle_area {

	public static void main(String[] args) {
		double radius;
		double area;
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력하시오 :");
		radius = sc.nextDouble();
		area = radius*radius*3.14;
		System.out.println(area);
	}
}
