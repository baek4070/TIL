package java_practice_1006;

import java.util.Scanner;

public class gradeSeperator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		while (isRun) {
			System.out.println("점수를 입력해주세요.");
		int	result = sc.nextInt();
		if (result > 100) {
			System.out.println("점수는 100점을 넘을수 없습니다");
		}else if(result >= 89) {
			System.out.println("A학점입니다.");
		}else if(result > 79) {
			System.out.println("B학점입니다.");
		}else if(result > 69) {
			System.out.println("C학점입니다.");
		}else if(result > 59) {
			System.out.println("D학점입니다.");
		}else{
			System.out.println("F학점입니다.");
		}
		}//while문 종료
	}//main문 종료
}
