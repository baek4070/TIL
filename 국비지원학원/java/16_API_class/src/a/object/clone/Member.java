package a.object.clone;

import java.util.Arrays;

// Cloneable 은 기능이 하나도 없음 클론 허용용 마크용 인터페이스
public class Member implements Cloneable{

	public String name;
	
	public int age;
	
	public int[] score;
	
	public Car car;
	
	public Member(String name, int age, int[] score, Car car) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
		this.car = car;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", score=" + Arrays.toString(score) + ", car=" + car + "]";
	}
	
	
	
	public Member getMember() {
		Member cloned = null;
		try {
			
//			cloned = (Member)super.clone();
			cloned = (Member)clone();
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
	//깊은 복제 
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Member cloned = (Member)super.clone();
		int[] score = new int[this.score.length]; // 원본 객체의 배열의 길이만큼 새로운 배열 생성
		for (int i = 0; i < score.length; i++) {
			score[i] = this.score[i];
		}
		cloned.score = score;
		Car car = new Car(this.car.model); // 원본 객체의 Car값과 똑같은 새로은 Car필드 생성
		cloned.car = car;
		return cloned;
	}


}
