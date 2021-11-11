package test1_class;

public class Person {

	
	public static String address;
	private String name;
	private int age;
	
	
	public Person() {
	}
	
	
	
	public Person(String name) {
		this.name = name;
	}
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}



	public static String getAddress() {
		return address;
	}



	public static void setAddress(String address) {
		Person.address = address;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
