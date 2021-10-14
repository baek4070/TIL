package object_array;

import java.util.Scanner;

import javax.swing.Box;

public class StudentExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student[] students = null;
		int selectNo =0;
		int stuCount =0;
		
		box :while(true) {
			System.out.println("====================================");
			System.out.println("1.학생수|2.정보입력|3.정보확인|4.분석|5.종료");
			System.out.println("====================================");
			selectNo = sc.nextInt();
			
			if (selectNo != 1 && selectNo !=5 && students == null) {
				System.out.println("학생 수를 먼저 입력해 주세요.");
				continue;
			}
			
			switch (selectNo) {
			case 1:
				System.out.println("학생 수 입력 :");
				stuCount = sc.nextInt();
				students = new Student[stuCount];
				System.out.println("학생수는 : "+students.length+"명 입니다.");
				break;
			case 2:
				System.out.println("학생 정보 입력 :");
				for (int i = 0; i < students.length; i++) {
					students[i] = new Student();
					students[i].number = (i+1);
					System.out.println(students[i].number+"번째의 학생 이름을 입력해주세요.");
					students[i].name = sc.next();
					System.out.println(students[i].number+"번째의 학생 점수를 입력해주세요.");
					students[i].score = sc.nextInt();
				}
				break;
			case 3:
				System.out.println("학생 정보 확인");
				break;
			case 4:
				System.out.println("학생 정보 분석");
				break;
			case 5:
				System.out.println("종료");
				break box;

			default:
				System.out.println("사용할 수 없는 번호입니다.");
			}
		}//while 종료
	}//main 종료

}
