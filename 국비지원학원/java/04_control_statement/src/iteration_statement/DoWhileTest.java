package iteration_statement;

import java.util.Scanner;

public class DoWhileTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isLogin = false;
		while (isLogin) {
			System.out.println("while 실행");
		}
		do {
			System.out.println("do while 실행");
			System.out.println("====로그인====");
			System.out.println("아이디를 입력해주세요>");
			String id = sc.next();
			System.out.println("비밀번호를 입력해주세요>");
			String pw = sc.next();
			if (id.equals("id001")&& pw.equals("pw001")) {
				System.out.println("로그인 성공");
				break;
			}else {
				isLogin = true;
			}
		} while (isLogin);
		
	}
}
