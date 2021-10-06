package Practice_1006_teacher;

public class Practice04ForSum {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i < 11; i++) {
//			System.out.print(i+" ");
			System.out.printf("%-2d",i);
			//sum += i;
			sum = sum + i;
		}
		System.out.println();
		System.out.println("합 : "+sum);
	}
}
