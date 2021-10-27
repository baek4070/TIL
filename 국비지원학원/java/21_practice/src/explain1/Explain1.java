package explain1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Explain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> grades = new ArrayList<>();
		ArrayList<Character> list = new ArrayList<>();
		System.out.println("6개의 학점을 빈 칸으로 분리 입력 (A/B/C/D/F) >>");
		String lineString = sc.nextLine();
		System.out.println("입력완료");
		String[] strs = lineString.split(" ");
		System.out.println(Arrays.toString(strs));
		
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
			char c = strs[i].charAt(0);
			list.add(c);
		}
		double sum1 = 0;
		for(char s : list) {
			switch (s) {
			case 'A':
				sum1 += 4.0;
				break;
			case 'B':
				sum1 += 3.0;
				break;
			case 'C':
				sum1 += 2.0;
				break;
			case 'D':
				sum1 += 1.0;
				break;
			case 'F':
				sum1 += 0;
				break;
			}
		}
		System.out.println("앞 : "+list);
		double avr = sum1 / list.size();
		DecimalFormat df = new DecimalFormat("##.##");
		String result1 = df.format(avr);
		System.out.println("평균은 : " + result1);
		System.out.printf("평균(1)은 : %.2f%n",avr);
		avr = Math.round((sum1/list.size())*100)/100;
		System.out.println("평균은 : "+ avr);
		
		
		
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
		System.out.println("평균(2)은 : "+ result );
		System.out.println("시스템 종료");
	}

}
