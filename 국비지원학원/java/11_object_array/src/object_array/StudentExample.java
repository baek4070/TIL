package object_array;

import java.util.Scanner;

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
				if(students[0] == null) {
					System.out.println("학생정보를 입력해주세요");
					continue box;
				}
				for(Student s : students) {
					System.out.println(s.toString());
				}
				break;
			case 4:
				System.out.println("학생 정보 분석");
				//total , max , min , avg
				int total = 0;		// 총점
				int max,min;		// 최고, 최저
				max = min = students[0].score;
				double avg = 0;		// 평균
				
				Student stuMax =null;
				Student stuMin =null;
				
				for (int i = 0; i < students.length; i++) {
					int score = students[i].score;
					total += score;
					if (max < score) {
						max = score;
						stuMax = students[i];
					}
					if (min > score) {
						min = score;
						stuMin = students[i];
					}
				}
				avg = (double)total/stuCount;
				System.out.println("전체 점수 : " + total);
				System.out.println("최고 점수 : " + stuMax.toString());
				System.out.println("최저 점수 : " + stuMin.toString());
				System.out.printf("평균 점수 : %.1f", avg);
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
