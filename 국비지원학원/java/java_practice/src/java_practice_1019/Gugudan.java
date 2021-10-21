package java_practice_1019;

public class Gugudan {

	public static void main(String[] args) {

		for (int i = 9; i >= 2; i--) {
			for (int j = 9; j >= 2; j--) {
				System.out.printf("%d * %d = %d\t",i,j,i*j);
			}
			System.out.println();
		}
	}

}
