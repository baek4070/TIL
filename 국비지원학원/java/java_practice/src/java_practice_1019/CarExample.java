package java_practice_1019;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.color = "red";
		myCar.speed = 0;
		myCar.gear = 1;
		System.out.println(myCar);
		myCar.speedUp();
		myCar.gear = 2;
		System.out.println(myCar);
		myCar.speedDown();
		myCar.gear = 1;
		System.out.println(myCar);
	}

}
