
public class VariableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 한줄주석
		
		/*
		 * comments 주석 다중 행 주석 
		*/ 
		byte bNum;
		//System.out.println(넘겨받은 값);
		// 넘겨받은 값을 console 에 출력
		//bNum 변수의 값을 127로 초기화
		bNum = 127;
		System.out.println(bNum);
		// byte == 1byte의 저장 공간 -128 ~ 0 ~ 127
		//bNum = 128;
		//byte bNum = 127; //변수 이름은 중복 불가
		
		//byte type의 변수 b1,b2,b3를 한번에 선언
		byte b1,b2,b3;
		b1 = 10;
		b2 = -10;
		b3 = (byte)-b2;
		
		System.out.println(b1+b2+b3);
		
		// 2byte 저장공간을 가지는
		// short, char(Character)
		// 65536가지의 값을 표현
		short sNum;
		//sNum = 34000;
		sNum = 20000;
		System.out.println(sNum);
		// 2byte 크기로 유니코드 한개의 문자를 표현하는 데이터 타입
		// 홑따옴표 = 한개의문자 문자열~ 
		// 쌍따옴표 = 긴 문자열 ~ 
		char cNum = '가';
		System.out.println(cNum);
		char cNum2 = 'A';
		System.out.println(cNum2);
		char cNum3 = 65;
		System.out.println(cNum3);
		
		//Integer 4byte 정수
		int iNum = 2100000000;
		int iNum2 = 2100000000;
		System.out.println(iNum+iNum2);
		
		long lNum = iNum + iNum2; // 8바이트 공간에 저장하라는 의미로 L을 붙임
		System.out.println(lNum);
		long lNum2 = 32000000000000000l;
		System.out.println(lNum2);
		lNum2 = 2100000000;
		System.out.println(lNum2);
		
		// 실수 decimal
		// float 4byte - 소수점 7자리
		float f = 3.14f; //f 로 8바이트가 아닌 4바이트를 사용해도 충분한 실수인지를 알려줘야함
		System.out.println(f);
		//double 8byte - 소수점 15자리 - 실수 형 기본 리터럴
		double d = 3.14;
		System.out.println(d);
		double fNum = f+d;
		System.out.println(fNum); // 왜 값이 지저분하노
		
		int result = 10/4;
		System.out.println(result);
		
		// 1byte에 논리값을 저장 true , false
		boolean isTrue = false;
		System.out.println(isTrue);
		isTrue = true;
		System.out.println(isTrue);
		
		String s = "문자열을 저장하는 녀석"; // API CLASS 입니다 , char type으로 저장
		System.out.println(s);
		// 기본타입을 제외한 나머지는 전부다 참조변수입니다 ~  String 도 참조변수 맞습니다
	}
	
  
}
