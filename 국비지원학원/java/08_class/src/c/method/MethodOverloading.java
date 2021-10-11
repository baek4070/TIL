package c.method;

public class MethodOverloading {

	public void methodA() {
		System.out.println("methodA 호출");
	}
	public void methodA(int a) {
		System.out.println("methodA 호출"+a);
	}
	public void methodA(double a) {
		System.out.println("methodA 호출"+a);
	}
	public void methodA(int a, int b) {
		System.out.println("methodA 호출"+a+"b :"+b);
	}
	public void methodA(int a, double b) {
		System.out.println("methodA 호출"+a+"b :"+b);
	}
	public void methodA(double a, int b) {
		System.out.println("methodA 호출"+a+"b :"+b);
	}
	
	void methodF(String s, int a, double...d) {}
	String methodB(char a, char b, char c) {
		return a+":"+b+":"+c;
	}
	//가변형 매개변수  //char 이라는 데이터 타입이 몃개가 들어올지 모른다 //즉 배열이 된다 ! 
	String methodB(char...a) {
		String result = null;
		for(int i = 0; i<a.length; i++) {
			result += a[i]+":";
		}
		return result;
	}
	public static void main(String[] args) {
		MethodOverloading m1 = new MethodOverloading();
		String result = m1.methodB('최','기','근');
		System.out.println(result);
		result = m1.methodB('A');
		System.out.println(result);
		result = m1.methodB('A','B');
		System.out.println(result);
		result = m1.methodB('A','B','C','D','E'); //매개변수의 길이가 함수를 호출하는순간 매개변수의 개수만큼 정의된다
		System.out.println(result);
	}
}
