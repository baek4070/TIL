package d.constructor;

public class Car { //클래스 이름과 동일해야 생성자이다 

	String company;
	String model;
	String color;
	int maxSpeed;
	int speed;
	/*
	Car(){
		System.out.println("기본 생성자 호출");
	}
	*/
	Car(String c, String m, int s){
		company = c;
		model = m;
		maxSpeed =s;
	}
	Car(String company,
			String model, 
			String color){
		this.company = company;
		this.model = model;
		this.color = color;
		System.out.println("3개의 매개변수를 넘겨받는 생성자 호출");
	}
	
	Car(String company,
			String model, 
			String color,
			int maxSpeed,
			int speed){
		this(company,model,color);
		this.maxSpeed = maxSpeed;
		this.speed = speed;
		System.out.println("전체 필드의 값을 넘겨받는 생성자 호출");
	}
	
}
