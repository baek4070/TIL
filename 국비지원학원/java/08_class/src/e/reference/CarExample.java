package e.reference;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.company);
		System.out.println(car.model);
		System.out.println(car.engine);
		car.company = "현대자동차";
		car.model = "싼타페";
		Engine engine = new Engine();
		car.setEngine(engine);
//		car.engine = new Engine();
		
		System.out.println(engine == car.engine);
		
		engine.rpm = 2000;
		System.out.println(car.engine.rpm);
		
		
		Car car2 = new Car();
		car2.company ="KIN";
		car2.model ="모닝";
		car2.engine = new Engine();
		car2.engine.maxSpeed =280;
		//이거나 아래거나 다름이 없다 (?????)
		Engine engine2 = new Engine();
		car2.setEngine(engine2);
		//car2.setEngine(new Engine());
	}
}
