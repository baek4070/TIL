package java_practice_1006;

public class sumCalc {
	public static void main(String[] args) {
	int i;
	int sum = 0;
	for (i = 1; i < 11; i++) {
		System.out.print(i+" ");
		sum = sum + i;
	}
	System.out.println("\n합 : "+sum);
	}
}
