package generic05_extends;

public class Util {
	//넘버 클래스이거나 넘버클래스 상속받는 객체여야 한다 
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		if(v1 > v2) {
			return (int)v1;
		}else {
			return (int)v2;
		}
	}
}
