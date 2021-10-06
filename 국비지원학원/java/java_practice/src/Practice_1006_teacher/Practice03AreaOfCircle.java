package Practice_1006_teacher;

import java.util.Scanner;

public class Practice03AreaOfCircle {

	public static void main(String[] args) {
		// (원의 면적 : 반지름 * 반지름 * 원주율(3.14))
		double radius;
		double area;
		double pi = 3.14;
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력하시오.");
		radius = sc.nextDouble(); 
		//.next - 하나의 word를 읽어옴  
		//.nextLine - 하나의 줄을 읽어옴
		//.nextInt - 해당 타입으로 읽어옴
		//.nextByte - 해당 타입으로 읽어옴
		//.nextFloat - 해당 타입으로 읽어옴
		area = (radius*radius*pi);
		// %.1 소수점 첫째자리 까지만 출력하겠다
		System.out.printf("반지름은 : %.1f인 원의 면적은 : %.1f",radius,area);
		
	}

}
