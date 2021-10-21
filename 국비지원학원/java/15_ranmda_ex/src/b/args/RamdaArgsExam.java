package b.args;

public class RamdaArgsExam {
	//매개변수가 있는경우 람다식 표현방법 --------------------------
	public static void main(String[] args) {
		MyInterface i = new MyInterface() {
			
			@Override
			public void method(int x, int y) {
				int sum = x + y;
				System.out.println("sum : "+ sum);
			}
		};
		i.method(1, 10);
		// 앞의 괄호가 메소드의 매개변수를 정의하는 괄호
		i = (a,b)->{
			int result = a*b;
			System.out.println("result : " + result);
		};
		i.method(10, 30);
	}
}
