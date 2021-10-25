package generic07_whildcard;

public class CourseExample {

	public static void registerCourse(Course<?> course) {
		System.out.println("["+ course.getName()+" 수강생]");
		for(int i=0; i<course.getStudents().length;i++) {
			System.out.print(course.getStudents()[i]+" ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<>("일반인과정", 5);
	}

}
