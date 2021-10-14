package object_array;

import java.util.Scanner;

public class KoreanExample {

	public static void main(String[] args) {
		Korean[] k1 = new Korean[2];
		System.out.println(k1);
		System.out.println(k1[0]);
		System.out.println(k1[1]);
		
		k1[0] = new Korean();
		k1[0].name = "최기근";
		k1[0].birth="820607";
	
		k1[1] = new Korean();
		k1[1].name = "김유신";
		k1[1].birth="000000";
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i< k1.length; i++) {
			System.out.println(k1[i].name);
			System.out.println(k1[i].birth);
		}
	}
}
