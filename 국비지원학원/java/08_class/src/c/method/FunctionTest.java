package c.method;

public class FunctionTest {
	// num1 / num2 연산 후 결과를 출력
	void divide(double num1, int num2) {
		if(num2 == 0) {
			System.out.println("나누는 수는 0이 될수 없습니다.");
//			return; //void(넘겨주는값이 없더) 라도 return문을 사용가능(그냥 함수의 종료 의미로서)
		}
		double result = num1 / num2;
		System.out.println(num1+"/"+num2+"="+result+"입니다.");
	}
	
	public static void main(String[] args) {
		FunctionTest f = new FunctionTest();
		f.divide(10, 0);
	}

}
