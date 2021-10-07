package type_cast;

public class TypeCastExample {

	public static void main(String[] args) {
		byte b = 100;
		// byte 타입의 값을 int 타입으로 변환하여 대입
		// 컴파일러가 실행시에 자동으로 변환
		int i = b;
		// 값을 잃어도 사용할 수 있다고 컴파일러에게 알려줌
		// 강제 형변환
		byte b1 = (byte)i;
		byte b2= 100;
		byte b3 = 50;
		
		byte b4 = (byte)(b2 + b3);
		
		int engScore = 100;
		int mathScore = 80;
		int koScore = 85;
		int count = 3;
		
		int sum = engScore + mathScore + koScore;
		int avg = (int)(sum / 3.0);
		
		double average = sum / (double)count;
		
		int value = 70000;
		short result = (short)value;
		System.out.println("result :"+ result);
		
	}

}
