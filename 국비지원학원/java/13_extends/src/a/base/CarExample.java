package a.base;

class Car  //extends Object //모든 객체들이 상속받고 있는 녀석 
{
	
	String company = "기아자동차";
	int maxSpeed;
	
	Car(){
		super(); // 무조건 생성자의 제일위에 설정
		System.out.println("기본생성자 호출");
	}
	
	Car(String company){
		System.out.println("company를 넘겨받는 생성자");
		this.company = company;
	}
	
	public String toString() {
		return "Car [company = "+this.company+","+" maxSpeed="+this.maxSpeed+"]";
	}
} //end Car class

class Texi extends Car{
	Texi(){
		super(); // 항상 생략되어있는것
		System.out.println("Texi 기본 생성자 호출");
	}
}
class Bus extends Car{
	Bus(){
		super("기아 자동차");
		System.out.println("버스 기본 생성자 호출");
	}
}

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.toString());
		System.out.println("=================");
		Texi texi =new Texi();
		texi.company = "Benz";
		texi.maxSpeed = 100;
		System.out.println(texi.toString());
		System.out.println("=================");
		
		Bus bus = new Bus();
		bus.maxSpeed = 300;
		System.out.println(bus.toString());
	}

}
