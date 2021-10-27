package c5_comparable;

public class Person implements Comparable<Person>{

	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override // 정렬기준을 잡아줌 ! 
	public int compareTo(Person o) {
		//나이를 기준으로 내림차순
		/*
		if(this.age > o.age) {
			return -1;
		}else if (this.age == o.age){
			return 0;
		}else {
			return 1;
		}
		*/
		//앞뒤 순서만 바꾸면 오름차순 내림차순 변경가능
		return o.age - this.age;// 이렇게 간단하게 할수가있다
	}
	
	
}
