package test1029.number1;

class Animal{}

class Cat extends Animal{}

class Tiger extends Animal{}


public class ExtendsTest {

	public static void main(String[] args) {
		
		Animal c = new Cat();
		Animal t = new Tiger();
		if (t instanceof Cat) {
			Cat cat = (Cat)t;
			System.out.println("Cat Type입니다");
			System.out.println(cat);
		} else {
			System.out.println("Cat Type이 아닙니다");
		}
	}//main 종료
}//class종료
