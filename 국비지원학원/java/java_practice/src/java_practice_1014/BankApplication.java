package java_practice_1014;

import java.util.Scanner;

public class BankApplication {
	// account란 이름의 길이 100짜리 객체 배열 생성
	Account[] account = new Account[100];
	
	Scanner sc = new Scanner(System.in);

	private int i=0;
	//기본 생성자
	BankApplication(){
		run();
	}
	
	void run() {
		// 1. 계좌생성
		// 2. 계좌조회 
		// 3. 예금
		// 4. 출금
		// 5. 종료
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("========================================");
			System.out.println("1.계좌생성 2.계좌조회 3.예금 4.출금 5.종료");
			System.out.println("========================================");
			int selectNo = sc.nextInt();
			if(selectNo == 1) {
				// 계좌생성
				createAccount();
			}else if(selectNo ==2) {
				// 계좌조회
				selectAccount();
			}else if(selectNo ==3) {
				// 예금
				deposit();
			}else if(selectNo ==4) {
				// 출금
				withdraw();
			}else if(selectNo ==5) {
				// 종료
				isRun = false;
				sc.close();
			}
		}
		System.out.println("프로그램 종료");
	}
	
	
	//계좌생성
	void createAccount() {
		if (account[i]==null) {
			System.out.println("-----------------");
			System.out.println("계좌생성");
			System.out.println("-----------------");
			account[i] = new Account();
			System.out.print("계좌주 : ");
			account[i].owner = sc.next();
			System.out.print("계좌번호 : ");
			account[i].ano = sc.next();
			System.out.print("초기입금액 : ");
			account[i].balance = sc.nextInt();
			System.out.print("비밀번호 : ");
			account[i].password = sc.next();
			System.out.println("계좌생성이 완료되었습니다");
			i++;
		}
	}
	// 계좌조회
	void selectAccount() {
		System.out.println("--------------");
		System.out.println("계좌 목록");
		System.out.println("--------------");
		Account r = findAccount();
		if( r != null) {
				System.out.print(r.toString()+"\n");
		}
	}
	
	// 예금
	void deposit() {
		System.out.println("--------------");
		System.out.println("예금");
		System.out.println("--------------");
		Account r = findAccount();
		if( r != null) {
				System.out.print("예금액 : ");
				r.balance += sc.nextInt();
				System.out.print(r.owner+"님의 계좌에 입금이 완료 되었습니다 \n현재 잔액 : "+ r.balance+"\n");
		}
	}
	//출금
	void withdraw() {
		System.out.println("--------------");
		System.out.println("출금");
		System.out.println("--------------");
		Account r = findAccount();
		if( r != null) {
				System.out.print("출금액 : ");
				r.balance -= sc.nextInt();
				System.out.print(r.owner+"님의 계좌에 출금이 완료 되었습니다 \n현재 잔액 : "+ r.balance+"\n");
		}
	}
	
	// 계좌번호와 비밀번호가 일치하는 Account 객체를 찾아서 반환 
	Account findAccount() {
		System.out.print("계좌번호 : ");
		String inputAno = sc.next();
		System.out.print("비밀번호 : ");
		String inputPassword = sc.next();
		for (int j = 0; j < i; j++) {
			if (inputAno.equals(account[j].ano) && inputPassword.equals(account[j].password)) {
				return account[j];
			}
		}
		System.out.println("일치하는 계좌정보가 없습니다");
		return null;
	}
	
	public static void main(String[] args) {
		new BankApplication();
	}
}
