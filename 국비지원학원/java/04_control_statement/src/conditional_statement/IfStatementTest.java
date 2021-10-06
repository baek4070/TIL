package conditional_statement;


public class IfStatementTest {
	
	public static void main(String[] args) {
		
		int a = 10;
		int b = 100;
		boolean op = a > b;
		if(!op)System.out.println("a가 b보다 작거나 같습니다.");
		if(a < b) {
			System.out.println("a : " + a);
			System.out.println("b : " + b);
			System.out.println("a가 b보다 작습니다.");
			
		}else {
			System.out.println("a가 b보다 크거나 같습니다.");
			
		}
		
		int score = 75;
		if(score >= 90) {
			System.out.println("A");
		}else if(score>=80) {
			System.out.println("B");
		}else if(score>=70) {
			if (score >= 77) {
				System.out.println("C+");
			}else if(score >=73) {
				System.out.println("C0");
			}else  {
				System.out.println("C-");
			}
		}else if(score>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
		// console을 통해 사용자에게 값을 입력받는 class
		java.util.Scanner sc = new java.util.Scanner(System.in);
		// sc.next(); - 사용자에게 한개의 단어를 입력받음(word)
		// sc.nextInt(); - 사용자에게 한개의 정수를 입력받음(int)
		// sc.nextLine(); - 사용자에게 한행의 문자열을입력받음(string)
		
		String userId= "id001";
		String userPw= "pw001";
		
		System.out.println("ID를 입력하세요 >");
		String id = sc.next(); //입력대기 상태
		System.out.println("패스워드를 입력해주세요>");
		String pw = sc.next(); //입력대기 상태
		System.out.println("id : " + id);
		System.out.println("pw :" + pw);
		
		if (userId.equals(id) && userPw.equals(pw)) {
			System.out.println("회원정보가 일치합니다.");
		}else {
			System.out.println("회원정보가 일치하지 않습니다.");
		}
		
		System.out.println("Main Method 종료");
	}//main 종료
}// class 종료