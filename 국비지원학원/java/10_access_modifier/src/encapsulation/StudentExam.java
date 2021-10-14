package encapsulation;

public class StudentExam {

	public static void main(String[] args) {
			Student choi = new Student();
			choi.name = "최기근";
//			choi.age = 26;
//			choi.grade = 4;

			
			choi.setAge(-60);
//			choi.age = -60;
//			choi.grade = -6;
			choi.setAge(40);
			String choiInfo = choi.toString();
			System.out.println(choiInfo);
					
	}
}
