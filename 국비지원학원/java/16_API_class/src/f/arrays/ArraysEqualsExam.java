package f.arrays;

import java.util.Arrays;

public class ArraysEqualsExam {

	public static void main(String[] args) {
		int[][] original = {{1,2},{3,4}};
		System.out.println("얕은 복제");
		int[][] copy1 = Arrays.copyOf(original, original.length);
		System.out.println(original+"]]"+copy1+"]]");
		System.out.println("배열 번지 비교 : "+original.equals(copy1));
		System.out.println(original[0]+"]|"+copy1[0]+"]|"+original[1]+"]|"+copy1[1]+"]");
		//즉 카피본의 값을 변경하면 원본도 영향을 받는다
		System.out.println("1차원배열 항목값 비교 : "+ Arrays.equals(original, copy1));
		System.out.println("2차원배열 내부의 값 비교 : "+ Arrays.deepEquals(original, copy1));
		
		System.out.println();
		System.out.println("깊은 복제 후 비교");
		int[][] copy2 = Arrays.copyOf(original, original.length);
		copy2[0] =Arrays.copyOf(original[0], original[0].length);
		copy2[1] =Arrays.copyOf(original[1], original[1].length);
		System.out.println("배열 번지 비교 : "+ original.equals(copy2));
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy2));
		System.out.println("1차원 배열 비교 : "+ Arrays.equals(original,copy2));
		//2차원 배열의 안의 값들을 출력 
		System.out.println(Arrays.deepToString(original));
		System.out.println(Arrays.deepToString(copy2));
		System.out.println("2차원 배열 비교 : "+ Arrays.deepEquals(original,copy2));
	}

}
