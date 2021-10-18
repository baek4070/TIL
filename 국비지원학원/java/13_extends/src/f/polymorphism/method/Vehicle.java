package f.polymorphism.method;

public class Vehicle {

	public void run() {
		System.out.println("탈것이 달립니다");
	}
}

class Bus extends Vehicle{
	public void run() {
		System.out.println("버스가 승객을 태우고 달립니다");
	}
}

class Texi extends Vehicle{
	public void run() {
		System.out.println("택시가 승객을 모시고 달립니다.");
	}
}

class Motorcycle extends Vehicle{
	public void run() {
		System.out.println("오토바이가 두바퀴로 달립니다");
	}
}
