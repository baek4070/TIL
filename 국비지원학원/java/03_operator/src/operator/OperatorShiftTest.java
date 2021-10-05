package operator;

public class OperatorShiftTest {

	public static void main(String[] args) {
		// <<, >>, >>> bit값을 제어하는 연산자
		byte num = 5;
		//0B(이진수)
		//0B00000101 == 5
		System.out.println("num << 2 : " + (num << 2));
		
		for(int i = 1; i<=10;) {
			System.out.println(i <<= 1);
		}
	}
}
