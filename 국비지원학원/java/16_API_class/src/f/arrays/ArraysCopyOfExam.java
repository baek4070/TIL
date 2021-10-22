package f.arrays;

import java.util.Arrays;

public class ArraysCopyOfExam {

	public static void main(String[] args) {
		// 배열 복제
		char[] arr1 = {'J','A','V','A'};
		System.out.println("array1 : "+Arrays.toString(arr1));
		char[] arr2 = Arrays.copyOf(arr1, 3);
		System.out.println("array2 : "+Arrays.toString(arr2));
		
		char[] arr3 = Arrays.copyOf(arr1, arr1.length);
		System.out.println("array3 : "+Arrays.toString(arr3));
		
		// 특정 범위 복제 copyOfRange
		char[] arr4 = Arrays.copyOfRange(arr1,1,3);
		System.out.println(Arrays.toString(arr4));
		char[] arr5 = Arrays.copyOf(arr1,arr1.length+1);
		arr5[arr1.length] = '!';
		System.out.println(Arrays.toString(arr5));
		
	}

}
