package java_practice_1008;

public class GetMinInArray {

	public static void main(String[] args) {
		int s[] = { 12, 3, 19, 6, 18, 8, 12, 4, 1, 19};
		int minimum = s[0];
//		for (int i = 0; i < s.length; i++) {
//			if (minimum > s[i]) {
//				minimum = s[i];
//			}
//		}
		for (int i : s) {
			minimum = (i < minimum) ? i : minimum;
		}
		System.out.println("최소값은 : "+minimum);
	}

}
//최대값도 한번 해보자
