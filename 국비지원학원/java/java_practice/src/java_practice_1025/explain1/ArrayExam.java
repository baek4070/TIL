package java_practice_1025.explain1;

import java.util.Arrays;

public class ArrayExam {
	
		
	private static <T> void printArray(T[] t) {
		System.out.println(Arrays.toString(t));
	}
		
		
	public static void main(String[] args) {
		Integer[] iArray = { 10, 20, 30, 40, 50};
		Double[] dArray = {1.1, 1.2, 1.3, 1.4, 1.5};
		Character[] cArray = {'K', 'O', 'R', 'E', 'A'};
		
		ArrayExam.<Integer>printArray(iArray);
		printArray(dArray);
		printArray(cArray);
	}

}
