package operator;

public class OperatorLogicTest {

	public static void main(String[] args) {
		// 논리 연산자 : &&, || , ^ , !
		// | == shift + \
		
		int num1 = 5;
		int num2 = 10;
		
		// && 논리 곱
		// 둘다 true(참) 일때만 참,
		// 둘중에 하나라도 만족하지 못하면 거짓(false)
		boolean result = (num1 < 0) && (num2++ > 0); 
		// 좌측에서 이미 값을 만족해버리면 우측연산은 진행안됨
		System.out.println("result : " + result);
		System.out.println(num1 + "|" + num2);
		// || 논리합
		// 둘중에 하나라도 참이면 참.
		// 둘다 거짓(false)일때 거짓
		num1 = 0;
		num2 = 0;
		result = (++num1 < 0) || (num2++ > 0);
		System.out.println("result : " + result);
		System.out.println(num1 + " | " + num2);
		
		// ^ 베타
		// 둘의 논리 값이 서로 달라야 true
		// 같으면 false
		result = (num1 > 0) ^ (num2 >0);
		System.out.println("^ result : "+ result);
		
		// 논리 부정
		// !true = false;
		// !false = true;
		// syso + ctrl + space
		// 출력문 자동완성 System.out.println();
		System.out.println("!result : " + !result);
		}
	
}
