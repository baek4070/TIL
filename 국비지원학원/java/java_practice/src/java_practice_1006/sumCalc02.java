package java_practice_1006;

public class sumCalc02 {
	public static void main(String[] args) {
		int i;
		int sum = 0;
		for (i = 1; i < 100; i = i + 2) {
			sum = sum + i;
		}
		System.out.println("홀수의합 : "+sum);
		}
}
