package java_practice_1008;

import java.util.Scanner;

public class TheaterReserve {

	public static void main(String[] args) {
		final int size = 10;
		int[] seats = new int[size];
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("---------------------------");
			for (int i = 0; i < size; i++)
				System.out.print(i+1 + " ");
			System.out.println("\n-----------------------------");
			for (int i = 0; i < size; i++)
				System.out.print(seats[i] + " ");
			System.out.println("\n-----------------------------");
			
			System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1): ");
			
			//문자 인지  정수인지  체크 하고 문자일경우 다시 실행하는 로직
			boolean isCheck = scan.hasNextInt(); // 무조건 얘가 28번 라인보다 위에 있어야 함
			if(!isCheck) {
				scan.next(); // scan에 값이 남아 있기때문에 여기서 한번 뱉어줘야 됨  
				continue;  // 안그러고 continue 하면 계속 무한반복 continue 합니다
			}//문자 인지  정수인지  체크 하고 문자일경우 다시 실행하는 로직
			int seatNum = scan.nextInt(); // 좌석 입력
			if (seatNum == -1) {
				System.out.println("시스텝이 종료되었습니다");
				break; // break , continue 의 범위 확실히 공부할것 !! 
			}else if (seatNum > 10 || seatNum < 1) {
				System.out.println("선택할 수 없는 자리입니다");
				continue;
			}else if (seats[seatNum-1] == 1) {
				System.out.println("이미 예약된 좌석입니다");
				continue;
			}
			seats[seatNum-1] = 1;
			System.out.println("예약 되었습니다");
		}//while 종료
	}//main 종료
}//class 종료
