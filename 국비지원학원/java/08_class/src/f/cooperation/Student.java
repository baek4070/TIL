package f.cooperation;

public class Student {

	String studentName; 	// 학생이름
	
	int grade;				// 학년
	
	int money;				// 학생이 가지고 있는 돈

	// alt+s+a
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	void takeBus(Bus bus) {
		bus.take(900);
		this.money -= 900;
	}
	
	void takeSubway(Subway subway) {
		subway.take(1100);
		this.money -= 1100;
	}
	void showInfo() {
		System.out.println(
				studentName+"남은 금액은 "+money+"입니다."
		);
	}
	
	
}
