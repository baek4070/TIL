package Practice_1006_teacher;

public class Practice06AreaOfTrapezoid {

	public static void main(String[] args) {
		//((윗변+아랫변)*높이 / 2
		int top = 5;
		int bottom = 10;
		int height = 7;
		double area = (top + bottom) * height / 2.0;
		System.out.println("사다리꼴의 넓이 : " + area);
	}

}
