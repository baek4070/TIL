package explain1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayListExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> grades = new ArrayList<>();
		System.out.println("6개의 학점을 빈 칸으로 분리 입력 (A/B/C/D/F) >>");
		String lineString = sc.nextLine();
		StringTokenizer st = new StringTokenizer(lineString," ");
		while (st.hasMoreTokens()){
		Character gradeCharacter = st.nextToken().charAt(0);
		grades.add(gradeCharacter);
		}
		System.out.println(grades);
		int sum = 0;
		for (int i = 0; i < grades.size(); i++) {
			switch (grades.get(i)) {
			case 'A': case 'a':
				sum+=4;
				break;
			case 'B': case 'b':
				sum+=3;
				break;
			case 'C': case 'c':
				sum+=2;
				break;
			case 'D': case 'd':
				sum+=1;
				break;
			case 'F': case 'f':
				break;
			default:
				break;
			}
			
		}
		System.out.println((double)sum/grades.size());
		double result = Math.round((double)sum/grades.size()*100)/(double)100;
		System.out.println("평균은 : "+ result );
		System.out.println("시스템 종료");
	}

}
