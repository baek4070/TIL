package object_array;
//data class : 필요한 정보만을 저장하는 class,값의 전달을 목적으로 사용하는 class  // Value Object(VO)
public class Student {
	public int number;			// 학번
	
	public String name;			// 이름
	
	public int score;			// 점수
	
	//기본생성자
	public Student() {}
	
	public Student(int number, String name, int score) {
		this.number = number;
		this.name = name;
		this.score = score;
	}

	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", score=" + score + "]";
	}
	
	
	
}
