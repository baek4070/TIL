package array;

import java.util.Scanner;

public class StudentManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//프로그램 종료 flag
		boolean isRun = true;
		//학생점수를 입력받아 저장할 공간
		int student[] = null;
		//학생 수를 입력받아 저장
		int studentNum = 0;
		int score;
		
		while(isRun) {
			System.out.println("====================================");
			System.out.println("1.학생수|2.점수입력|3.전체점수|4.분석|종료");
			System.out.println("====================================");
			System.out.println("선택하실 기능의 번호를 입력하세요>");
			int selectNo = sc.nextInt();
			System.out.println("선택하신 번호는 : " + selectNo);
			if (selectNo == 1) {
				System.out.println("학생수를 입력 하세요>");
				studentNum = sc.nextInt();
				student = new int[studentNum];
				System.out.println("학생수 : "+student.length);
				
			}else if(selectNo == 2) {
				for (int i = 0; i < student.length; i++) {
					System.out.println((i+1)+"번 학생의 점수를 입력하세요 (1~100) >");
					score = sc.nextInt();
					student[i] = score;
				}
			}else if(selectNo == 3) {
				System.out.println("전체점수");
				for (int i = 0; i < student.length; i++) {
					System.out.println((i+1)+"번 학생 : "+student[i]);
				}
			}else if(selectNo == 4) {
				System.out.println("분석");
				int scoreTotal = 0;
				int max= 0;
				int min= 100;
				for (int i = 0; i < student.length; i++) {
					scoreTotal += student[i];
				}
				System.out.println("모든 학생의 총점은 "+ scoreTotal +"입니다");
				System.out.println("모든 학생의 평균점수는 "+ (scoreTotal/student.length) +"입니다");
				for(int i = 0; i<student.length; i++) {
					if(student[i] > max) {
						max = student[i];
					}
					if (student[i] < min) {
						min = student[i];
					}
				}
				System.out.println("모든 학생중 최고점수는 "+ (max) +"입니다");
				System.out.println("모든 학생중 최저점수는 "+ (min) +"입니다");
				
			}else {
				System.out.println("종료합니다");
				break;
			}
			/*
			 *  1. 학생 수를 입력 -> 입력한 학생수 만큼 점수를 저장할 수 있는 배열 생성
			 *  2. scores 배열의 크기만큼 학생의 점수를 입력받아서 순차적으로 저장
			 *  3. scores 배열에 저장된 학생들의 점수를 출력
			 *  4. 분석 - (총점, 평균점수, 최고점수, 최저점수) 출력
			 *  - 종료
			 */
		}
	}
}
