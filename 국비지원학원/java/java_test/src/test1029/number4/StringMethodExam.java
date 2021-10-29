package test1029.number4;

import java.util.Scanner;

public class StringMethodExam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("문자열을 입력해 주세요>>");
			String input = sc.nextLine();
			
			if (input.indexOf("java") != -1) {
				System.out.println("java가 존재합니다");
				System.err.println("시스템을 종료합니다");
				break;
			}else {
				System.out.println("java가 존재 하지 않습니다.");
			};
		}
	}

}
