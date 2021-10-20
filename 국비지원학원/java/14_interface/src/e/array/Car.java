package e.array;

public class Car {
	String model;
	String color;
	int speed;
	
	Tire[] tires;
	
	void run() {
		for (Tire t :tires){
			t.roll();
		}
	}
	public Car() {
		tires = new Tire[] {
				new HankookTire(),
				new HankookTire(),
				new KumhoTire(),
				new KumhoTire()
		};
	}
	
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		myCar.tires[0] = new KumhoTire();
		myCar.tires[1] = new KumhoTire();
		myCar.run();
	}
}
