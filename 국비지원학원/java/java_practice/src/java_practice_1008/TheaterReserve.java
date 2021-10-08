package java_practice_1008;

import java.util.Scanner;

public class TheaterReserve {

	public static void main(String[] args) {
		final int size = 10;
		int[] seats = new int[size];
		Scanner scan = new Scanner(System.in);
reserve:while (scan.hasNextInt()) {
			System.out.println("---------------------------");
			for (int i = 0; i < size; i++)
				System.out.print(i+1 + " ");
			System.out.println("\n-----------------------------");
			for (int i = 0; i < size; i++)
				System.out.print(seats[i] + " ");
			System.out.println("\n-----------------------------");
			
			System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1): ");
			int s = scan.nextInt(); // 좌석 입력
			if (s == -1) {
				System.out.println("종료합니다");
				break reserve;
			}
			if (s > 10 ) {
				System.out.println("잘못된 값입니다");
				continue;
			}
			if (seats[s-1] == 1) {
				System.out.println("이미 예약된 좌석입니다");
				continue;
			}
			seats[s-1] = 1;
			System.out.println("예약 되었습니다");
		}
		System.out.println("잘못된 값입니다 종료합니다");
	}

}
