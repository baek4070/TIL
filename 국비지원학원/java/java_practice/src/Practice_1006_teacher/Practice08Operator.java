package Practice_1006_teacher;


public class Practice08Operator {
	public static void main(String[] args) {
		short s1 = 100;
		short s2 = 200;
		
		short result = (short)(s1 + s2);
		
		int resultInt = s1+s2;
		short resultShort = (short)resultInt;
		resultInt = resultShort;
		
		
	}
}
