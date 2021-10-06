package Practice_1006_teacher;

public class Practice05OddSum {
	// Eclipse -> window -> Preferences
	//
	public static void main(String[] args) {
		// 1~ 100 까지의 수중 홀수의 총합
		int sum = 0;
		int even = 0;
		for(int i = 1; i <= 100; i+=2) {
			System.out.print(i+" ");
			sum += i;
			even += (i+1);
		}
		System.out.println("\n홀수의 합은 : " + sum);
		System.out.println("\n짝수의 합은 : " + even);
	}

}
