package d.math;

public class MathExample {

	
	public static void main(String[] args) {
		// Math(수학 관련 처리 클래스)
		// 절대값을 알려주는 abs 함수
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1 : "+v1);
		System.out.println("v2 : "+v2);
		//실수를 넘겨받아 소수점 첫째 자리에서 올림연산 ceil
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("v3 : "+v3);
		System.out.println("v4 : "+v4);
		//실수를 넘겨받아 소수점 첫째 자리에서 내림연산 floor
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("v5 : "+v5);
		System.out.println("v6 : "+v6);
		//두개의 값을 넘겨 받아 둘중 큰수를 알려주는 함수
		int v7 = Math.max(10, 11);
		double v8 = Math.max(10.1, 10.2);
		System.out.println("v7 : "+v7);
		System.out.println("v8 : "+v8);
		//두개의 값을 넘겨 받아 둘중 작은수를 알려주는 함수
		int v9 = Math.min(10, 11);
		double v10 = Math.min(10.1, 10.2);
		System.out.println("v9 : "+v9);
		System.out.println("v10 : "+v10);
		
		int[] arrays = {40,60,50,43,21,5,100};
		int max,min;
		max=min=arrays[0];
		for (int i : arrays){
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		System.out.println("max : "+ max);
		System.out.println("min : "+ min);
		// 반올림 첫째자리
		// 값을 double 로 반환
		double v11 = Math.rint(5.311);
		double v12 = Math.rint(5.511);
		System.out.println("v11 : "+v11);
		System.out.println("v12 : "+v12);
		// 반올림 후 값을 정수로 반환
		long v13 = Math.round(5.451352);
		System.out.println("v13 : "+v13);
		
		double value = 12.3456;
		System.out.println("value : " + value);
		double temp = value * 100;
		System.out.println("temp : " + temp);
		long v14 = Math.round(temp);
		System.out.println("v14 : " + v14);
		double v15 = 14 / 100.0;
		System.out.println("v15 : " + v15);
		//pow(a,b)
		//a와 b에 대해서 제곱연산
		// pow(2,10) 2의 10승
		// pow(5,2) 5의 2승
		double v16 =Math.pow(2, 10);
		System.out.println("v16 : "+v16);
		
		int sum=0;
		for (int i = 0; i <=7; i++) {
			int result = (int)Math.pow(2, i);
			sum+= result;
			System.out.println("result : " + result + ", sum : "+ sum);
		}
		
		// 넘겨 받은 매개변수의 제곱근을 구함.
		double v17 =Math.sqrt(16);
		System.out.println("v17 : " +v17);
		
		//두수의 차이를 반환
		System.out.println(Math.subtractExact(11, -5));
		
		System.out.println(Math.random());
	}
}
