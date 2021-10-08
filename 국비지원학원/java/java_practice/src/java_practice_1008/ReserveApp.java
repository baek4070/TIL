package java_practice_1008;

import java.util.Scanner;

public class ReserveApp {

	public static void main(String[] args) {
		/*for (byte[] b : seats) {
			for(byte b1 : b) {
				if(b1 == 0) {
					System.out.print("[□]");
				}else {
					System.out.print("[■]");
				}
				System.out.println("["+b1+"]");
			}
			System.out.println();
		}
		 */
		byte[][] seats = new byte[10][10];
		Scanner sc = new Scanner(System.in);
		char inputColumn = 0;
		boolean isRun = true;
		while (isRun) {
			System.out.println("              [screen]");
			for (int i = 0; i < seats.length; i++) {
				System.out.print("["+(i+1)+"]");
			}
			System.out.println("[행]");
			for (int i = 0; i < seats.length; i++) {
				for (int j = 0; j < seats[i].length; j++) {
					if(seats[i][j] == 0) {
						System.out.print("[□]");
					}else {
						System.out.print("[■]");
					}
				}//j for 종료
				System.out.println(" ["+(char)(i+65)+"열]");
			}//i for 종료
			System.out.println("예약하실 좌석의 열을 입력해주세요.");
			String s = sc.next();
			inputColumn = s.charAt(0);
			if( (int)inputColumn >74 || (int)inputColumn <65) {
				System.out.println("잘못된 값입니다 처음부터 진행하세요");
				continue;
			}
			System.out.println("선택하신 열의 이름 : "+inputColumn);
			System.out.println("예약하실 좌석의 행번호를 입력해 주세요.");
			
			boolean isCheck = sc.hasNextInt();
			if(!isCheck) {
				sc.next();
				System.out.println("잘못된 값입니다 처음부터 진행하세요");
				continue;
			}
			
			int rowNum = sc.nextInt();
			if( rowNum > 10 || rowNum < 1) {
				System.out.println("잘못된 값입니다 처음부터 진행하세요");
				continue;
			}
			
			System.out.println("선택하신 좌석의 번호는 : " + inputColumn + "열" + rowNum + "행 입니다.");
			System.out.println("예약 완료 하시겠습니까? y/n");
			
			char yesOrNo = sc.next().charAt(0); // Y/N 선택
			
			//예약 완료 했을 경우
			if (yesOrNo == 'y' || yesOrNo == 'Y') {
				if(seats[(int)inputColumn-65][rowNum-1] == 1) {
					System.out.println("이미 예약 된 자리입니다. 예약을 취소 하시겠습니까? Y/N");
					yesOrNo = sc.next().charAt(0);
					if (yesOrNo == 'y' || yesOrNo == 'Y') {
						seats[(int)inputColumn-65][rowNum-1] = 0;
						System.out.println("예약 취소 되었습니다");
					}
					continue;
				}
				System.out.println("예약 완료 되었습니다");
				seats[(int)inputColumn-65][rowNum-1] = 1;   // input : char -> int 형변환 // A = 65 ~ 
				
			// 그밖에 취소
			}else { 
				System.out.println("예약이 취소되었습니다");
				System.out.println("다시 선택해 주세요");
				continue;
			}
		}//while 종료
//		Scanner sc = new Scanner(System.in);
//		String[][] seat = new String[10][10];  // 좌석 배열  10x10 // index : [0 ~ 9,0 ~ 9]
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				seat[i][j] = "[□]";
//			}
//		}
//		char[] alpha = new char[10];		   // char type 배열 10개( X열 ) // index[0 ~ 9]
//		boolean isRun = true;                  // 최상단 while  조건식
//		while (isRun) {
//			System.out.println("\t\t SCREEN ");
//			System.out.println("[1] [2] [3] [4] [5] [6] [7] [8] [9] [10] [행]");
//			for (int i = 0; i < 10; i++) {
//				for (int j = 0; j < 10; j++) {
//					if(seat[i][j].equals("[■]")) {
//						System.out.print(seat[i][j]+" ");
//					}else {
//					seat[i][j] = "[□]";
//					System.out.print(seat[i][j]+" ");
//					}
//				}
//				alpha[i]= (char)(65+i) ;
//				System.out.print("["+alpha[i]+"열]");
//				System.out.println();
//			}
//			System.out.println("예약해주실 좌석의 열을 입력해주세요>");
//			char input = sc.next().charAt(0); // 예약할 좌석의 열 
//			System.out.println("입력한 열 : "+input);
//			System.out.println("예약해주실 좌석의 행 번호를 입력해주세요>");
//			
//			int inputNum = sc.nextInt(); // 예약할 좌석의 행
//			System.out.println("선택하신 좌석은 : "+input+" 열 "+ inputNum+" 행입니다." );
//			System.out.println("예약 완료 하시겠습니까? y/n");
//			
//			char yesOrNo = sc.next().charAt(0); // Y/N 선택
//			
//			//예약 완료 했을 경우
//			if (yesOrNo == 'y' || yesOrNo == 'Y') {
//				if(seat[(int)input-65][inputNum-1].equals("[■]")) {
//					System.out.println("이미 예약 된 자리입니다. 다시선택해주세요");
//					continue;
//				}
//				System.out.println("예약 완료 되었습니다");
//				seat[(int)input-65][inputNum-1] = "[■]";   // input : char 타입 형변환 int // A = 65 ~ 
//				
//			// 그밖에 취소
//			}else { 
//				System.out.println("예약이 취소되었습니다");
//				System.out.println("다시 선택해 주세요");
//				continue;
//			}
//		} // while 종료
	}// main 종료
	
}
		
		
// char 문자열 하나를 입력 받는 방법
// Scanner의 sc.next() method는 문자열만 입력가능
// char 형태의 한문자 값을 받기 위해서는 연산이 필요
// char input = sc.next().charAt(0);
//문자열.charAt(index) ;
//문자열을 한글자 씩 짤라 첫글자부터 index를 부여 후 
//해당 index에 있는 ‘문자’를 반환 하는 method이다.
//(문자열을 char형태의 배열로 만든 후 해당 index의 ‘문자’ 제공)
//□ , ■
