package c.method;

public class AreaCalculator {
	// 사각형의 넓이를 계산
	// 정사각형
	int areaRectangle(int x) {
		return x * x;
	}
	// 직사각형
	int areaRectangle(int x, int y) {
		return x * y;
	}
	
	// 정밀도 향상
	double areaRectangle(double x, double y) {
		return x * y;
	}
	public static void main(String[] args) {
		AreaCalculator c = new AreaCalculator();
		int result = c.areaRectangle(10);
		int result1 = c.areaRectangle(10, 20);
		double result2 = c.areaRectangle(10.4, 20.2);
		System.out.println("result : " +result);
		System.out.println("result1 : " +result1);
		System.out.println("result2 : " +result2); 
	}

}
