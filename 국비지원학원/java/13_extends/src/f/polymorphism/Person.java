package f.polymorphism;

public class Person {
	String name;
	int age;
	int height;

	Person(){}
	
	public Person(String name, int age, int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}


	//상속받은 메소드에 대한 재정의 
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + "]";
	}


	
	
}
