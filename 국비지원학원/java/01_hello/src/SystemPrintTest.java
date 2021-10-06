
public class SystemPrintTest {

	public static void main(String[] args) {
		// print - 넘겨받은 값을 console 출력 하고 줄을 바꾸지 않음
		// println - 넘겨받은 값을 console 출력하고 줄을 바꿈
		// printf - print format 형식화된 출력문
		// printf 는 줄바꿈이 이루어지지 않음
		/*
		 * 출력 후 줄바꿈을 하려면 지시자를 이용 (%n or \n 이스케이프 문자를 사용)
		 * 출력하려는 값(지시자)의 수만큼 값을 넣어 줘야 한다.
		 * 예약되어 있는 지시자를 제외하고는 문자를 그대로 출력
		 * 
		 * 지시자
		 * 
		 * %d	-	int(decimal) 10진법 정수 형식으로 출력
		 * %b	-	boolean 형식으로 출력
		 * %o	-	oct 8진법으로 출력
		 * %x	-	16진법으로 출력
		 * %f	-	float - 실수 형태로 출력
		 * %c	-	charcater - 문자 형식으로 출력
		 * %s	-	string 문자 형태로 출력
		 * %n	-	줄바꿈
		 * 
		 * %[-][0][n][.m]
		 * %[n] : 출력할 전체 자리수를 지정(오른쪽 정렬) ex) %5d []1000 // 출력해보면 이해할것
		 * %[0] : 전체 자리수가 지정되어 있을 경우 오른쪽으로 정렬하고 빈칸에 0으로 채움 
		 * 		ex) %05d , 1000 = 01000
		 * %[-] : 전체 자리수가 지정된 경우 왼쪽으로 정렬하고 빈칸에 공백 출력
		 * %[.m] : 소수점 아래 자리수 지정. 잘리는 소수점 자리는 반올림 
		 * 0,- : 정수에서만 사용가능
		 */
		
		System.out.printf("%s의 교재는 %,020d원 입니다. %n", "Java", 100000000);
		//Java의 교재는 000000000100,000,000원 입니다. 
		System.out.printf("%s의 교재는 %,20d원 입니다. %n", "Java", 100000000);
		//Java의 교재는          100,000,000원 입니다.
		System.out.printf("%s의 교재는 %,-20d원 입니다. %n", "Java", 100000000);
		//Java의 교재는 100,000,000         원 입니다. 
		System.out.printf("%S의 교재는 %20d원 입니다. %n", "Java", 100000000);
		//JAVA의 교재는            100000000원 입니다. 
		
		System.out.printf("자리수 지정 : %4d%n",1);
		System.out.printf("자리수 지정 : %4d%n",10);
		System.out.printf("자리수 지정 : %4d%n",100);
		System.out.printf("자리수 지정 : %4d%n",1000);
		
		// %.mf - 소수점 자리
		System.out.printf("%.2f %n",1234.123);
		System.out.printf("%.2f %n",1234.127);
	}

}
