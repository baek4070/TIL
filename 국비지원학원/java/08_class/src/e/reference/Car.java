package e.reference;

public class Car {
	String company;
	String model; // 전역변수 // 필드
	
	Engine engine; // 부품객체
	
	//car ();
	
	void setEngine(Engine engine) {  // 메소드
		this.engine = engine;
	}
}

class Engine{
	int maxSpeed;
	int rpm;
}
