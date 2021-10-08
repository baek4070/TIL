package java_practice_1008;

import java.util.Scanner;

public class TriangleByTwoDimensionalArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		System.out.println("크기를 입력하세요 >");
		int size = sc.nextInt();
		int[][] inputArray = new int[size+1][];
		/* 크기  : 10
		 * 줄수  : 11
		 * 숫자  : 10 까지
		 * 
		 * [0,0] = 0
		 * [1,0] = 0, [1,1] = 1
		 * [2,0] = 0, [2,1] = 1, [2,2] = 2
		 * [3,0] = 0, [3,1] = 1, [3,2] = 2, [3,3] = 3
		 * .................
		 * [10,0]  .........................[10,10] = 10  
		 */
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = new int[(i+1)];
			for (int j = 0; j < i+1; j++) {
				inputArray[i][j]= j;
				System.out.print(inputArray[i][j]+" ");
			}
			System.out.println();
		}
	}

}
