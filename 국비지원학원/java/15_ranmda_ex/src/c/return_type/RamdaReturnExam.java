package c.return_type;
//리턴타입의 메소드의 경우 람다식 표현방법 -------------------------------------------
interface MyInterface{
	int method(int x, int y, String s);
}

public class RamdaReturnExam {

	public static void main(String[] args) {
		MyInterface i = new MyInterface() {
			
			@Override
			public int method(int x, int y, String s) {
				System.out.println(s);
				return x * y;
			}
		};
		
		int result = i.method(10, 5, "곱셈연산");
		System.out.println("result : " + result);
		
		i = (a,b,s)->{
			System.out.println(s);
			return a+b;
		};
		result = i.method(10, 20, "덧셈연산");
		System.out.println("result : "+ result);
		
		i = (a,b,s)-> a/b;
		System.out.println(i.method(30, 3, "gdf"));
		
		/*
		//이건 나중에 배울건데 암튼 자주 사용된다는 것입니다
		Thread t = new Thread(()->{
		});
		*/
		
	}
}
