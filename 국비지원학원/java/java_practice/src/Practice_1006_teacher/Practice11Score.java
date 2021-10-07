package Practice_1006_teacher;

import java.util.Scanner;

public class Practice11Score {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = 0;
		while(true) {
			System.out.println("점수를 입력해 주세요.");
			if(!sc.hasNextInt()) {
				System.out.println("사용할 수 있는 값이 아닙니다. \n종료합니다.");
				//break;
				sc.next();
				continue;
			}
			score = sc.nextInt();
			switch(score/10) {
			case 10 : case 9 : 
				System.out.println("A학점입니다.");
				break;
			case 8 : 
				System.out.println("B학점입니다.");
				break;
			case 7 : 
				System.out.println("C학점입니다.");
				break;
			case 6 : 
				System.out.println("D학점입니다.");
				break;
			default :
				System.out.println("F학점입니다.");
			}
		}
	}
}





