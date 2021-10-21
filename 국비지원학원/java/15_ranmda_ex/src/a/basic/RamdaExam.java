package a.basic;

public class RamdaExam {

	public static void main(String[] args) {
		//---------------------일반적으로 이렇게 표현 ----------------
		MyInterface myInterface = new MyInterface() {
			
			@Override
			public void method() {
				System.out.println("myInterface method 실행123");
			}
		};
		myInterface.method();
		//----------------------람다식으로 표현 ---------------------
		MyInterface yourInterface 
			= ()-> System.out.println("ramda method 실행 321");
		System.out.println("두번째 실행문");
		yourInterface.method();
		//----------------------람다식(블럭)으로 표현-----------------
		myInterface = ()->{
			String str = "method call";
			System.out.println(str+"실행 블럭1!");
			System.out.println("실행 블럭2!");
		};
		myInterface.method();
		
		
		
		
	}

}
