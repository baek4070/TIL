package d.constructor;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car("KIN", "K7", 280);
		System.out.println(car.company);
		System.out.println(car.model);
		System.out.println(car.maxSpeed);
		
		Car myCar = new Car("현대", "캐스퍼", "RED");
		System.out.println(myCar.company);
		System.out.println(myCar.model);
		System.out.println(myCar.maxSpeed);
		
		Car subCar 
		= new Car("BMW", "520d", "WHITE", 280, 0);
		System.out.println(subCar.model);
	}
}
