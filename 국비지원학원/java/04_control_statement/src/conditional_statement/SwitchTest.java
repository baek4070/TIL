package conditional_statement;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		// ctrl + shift + o //자동 임폴트
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		//사용자에게 값을 입력받아 정수로 제공
		int score = (sc.hasNextInt()) ? sc.nextInt() : 0;
		switch (score/10) {
		case 10 : case 9 :
			System.out.println("A");break;
		case 8 :
			System.out.println("B");break;
		case 7 :
			System.out.println("C");break;
		case 6 :
			System.out.println("D");break;
		default : System.out.println("F");
		}
		
		char c = 64;
		switch(c) {
		case 'A' :
			System.out.println("c : " +65);
			break;
		case 66 :
			System.out.println("c : " +66);
			break;
		case 'C' :
			System.out.println("c : " +67);
			break;
		default :
			System.out.println("c : " +c);
		}
	}//main종료

}
