package exam;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// while 문 반복 flag true = run, false = stop
		boolean isRun =true;
		// 사용자의 예금을 저장할 변수
		int money = 0;
		
BankApp :while(isRun) {
			System.out.println("================================");
			System.out.println(" 1.예금 | 2.출금 | 3.잔액확인 | 4.종료 ");
			System.out.println("================================");
			System.out.println("================================");
			System.out.println("================================");
			System.out.println("================================");
			System.out.println("원하시는 서비스의 번호를 입력해 주세요(1~4) > ");
			int selectNo = sc.nextInt();
			switch (selectNo) {
			case 1:
				System.out.println("입금할 금액을 입력하세요");
				int inputMoney = sc.nextInt();
				money = money + inputMoney;
				System.out.println("입금후 잔액 : " + money);
				break;
			case 2:
				System.out.println("출금할 금액을 입력하세요");
				int outputMoney = sc.nextInt();
				if (outputMoney> money) {
					System.out.println("입력하신 금액이 잔액보다 많습니다");
				} else {
					money = money - outputMoney;
					System.out.println("출금후 잔액 : " +money);
				}
				break;
			case 3:
				System.out.println("현재 잔액은 : "+ money +" 원 입니다.");
				break;
			case 4:
				break BankApp;
			default:
				System.out.println("잘못된 입력입니다 다시입력해주세요");
				break;
			}
			System.out.println("계속 진행하려면 아무글자나 입력해주세요");
			String something = sc.next();
//			
//			if (selectNo == 1) {
//				System.out.println("입금할 금액을 입력하세요");
//				int inputMoney = sc.nextInt();
//				money = money + inputMoney;
//				System.out.println("입금후 잔액 : " + money);
//			}else if (selectNo == 2) {
//				System.out.println("출금할 금액을 입력하세요");
//				int outputMoney = sc.nextInt();
//				if (outputMoney> money) {
//					System.out.println("입력하신 금액이 잔액보다 많습니다");
//				} else {
//					money = money - outputMoney;
//					System.out.println("출금후 잔액 : " +money);
//				}
//			}else if (selectNo == 3) {
//				System.out.println("현재 잔액은 : "+ money +" 원 입니다.");
//			}else if (selectNo == 4) {
//				break BankApp;
//			}else {
//				System.out.println("잘못된 값입니다 다시입력해주세요");
//			}
//			
			/*
			 * 1. 예금 - 입금할 금액을 입력 받아 money 변수에 누적 저장
			 * 2. 출금 - 출금할 금액을 입력 받아 money 변수 값에서 출금
			 * 		 - 단 출금 금액은 예금 금액을 초과할 수 없음. 
			 * 3. 잔액 - money 변수(입금액)을 출력
			 * 4. while문 종료 - 프로그램 종료
			 */
		} //while 종료
		System.out.println("Main 종료");
	}//main 종료
}//class 종료
