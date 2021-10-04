package operator;

public class OperatorArithmeticTest {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		
		// 양의 정수표현 - 없는 것과 동일
		System.out.println(+num1); 
		// 음의 정수 표현
		System.out.println(-num2);
		System.out.println(num2);
		
		num2 = -num2;
		System.out.println(num2);
		
		double pi = -3.141592;
		System.out.println(pi);
		
		int i = 10;
		int i2 = 3;
		int result = i/i2;
		System.out.println("result: " + result);
		
		double d = i / i2;
		System.out.println("d result : " + d);
		
		double typeResult = i / 3.0;
		System.out.println("typeResult : " + typeResult);
		// 연산 순서를 알아볼수있다
		// 문자열 연산자는 + 밖에없습니다
		String s ="최기근";
		System.out.println(s + num1 + num2);
		
		System.out.println(num1 + num2 + s);
		
		int a = 1;
		int b = 1;
		int c = a++;
		// c = a; a = a+1
		System.out.println("c : "+c);
		int e = b--;
		// e = b; b = b-1
		System.out.println("e : "+e);
		int f = ++a;
		// f = a+=1;
		System.out.println("f : "+f);
		int g = --b;
		// g = b-=1;
		System.out.println("g : "+g);
		
		
	}

}
