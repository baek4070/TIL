package generic07_whildcard;

import java.util.Arrays;
import java.util.HashMap;

public class CourseExample {

	public static void registerCourse(Course<?> course) {
		System.out.println("["+ course.getName()+" 수강생]");
		for(int i=0; i<course.getStudents().length;i++) {
			System.out.print(course.getStudents()[i]+" ");
		}
		System.out.println();
	}
	public static void registerStudent(Course<? extends Student> course) {
		System.out.println("["+ course.getName()+" 수강생]");
		System.out.println(Arrays.toString(course.getStudents()));
	}
	public static void registerWorker(Course<? super Worker> course) {
		System.out.println("["+ course.getName()+" 수강생]");
		System.out.println(Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<>("일반인과정", 5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Person("일반인2"));
		
		Course<Student> studentCourse = new Course<>("학생 과정", 5);
		studentCourse.add(new Student("일반학생"));
		studentCourse.add(new HighStudent("고등학생"));
//		studentCourse.add(new Person("일반인"));
		
		Course<HighStudent> highStudentCourse = new Course<>("고등학생 과정", 5);
		highStudentCourse.add(new HighStudent("고등학생"));
		
		Course<Worker> workerCourse = new Course<>("직장인과정", 5);
		workerCourse.add(new Worker("직장인"));
		System.out.println("====================================");
		registerCourse(personCourse);
		registerCourse(highStudentCourse);
		registerCourse(workerCourse);
		
		
		System.out.println("====================================");
		registerStudent(studentCourse);
//		registerStudent(personCourse);
		registerStudent(highStudentCourse);
		
		System.out.println("====================================");
		registerWorker(workerCourse);
		registerWorker(personCourse);
		registerWorker(new Course<Object>("전체교육과정", 50));
		
		HashMap<String,Integer> map = new HashMap<>();
		
	}

}
