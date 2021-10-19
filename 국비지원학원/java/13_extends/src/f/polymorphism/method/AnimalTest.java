package f.polymorphism.method;

class Animal extends Object
{
	public Animal() {
		super();
	}
	
	public void move() {
		System.out.println("동물이 움직입니다");
	}
}

class Tiger extends Animal{
	
	@Override
	public void move() {
		System.out.println("호랑이는 네발로 뜁니다");
	}
	
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}

class Eagle extends Animal{
	public void move() {
		System.out.println("독수리가 두발로 걷습니다.");
	
	}
	public void fling() {
		System.out.println("독수리가 날라갑니다");
	}
}

class Human extends Animal{
	@Override
	public void move() {
		System.out.println("사람이 두발로 걷습니다");
	}
	
	public void readBook() {
		System.out.println("사람이 책을 읽습니다");
	}
}

public class AnimalTest {

	public static void main(String[] args) {
		Animal animal = new Animal();
		moveAnimal(animal);
		moveAnimal(new Tiger());
		moveAnimal(new Eagle());
		Human h = new Human();
		moveAnimal(h);
	}
	
	public static void moveAnimal(Animal animal) {
		animal.move();
		if (animal instanceof Human) {
		Human h = (Human)animal;
		h.readBook();
		}
	}

}
