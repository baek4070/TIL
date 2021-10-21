package a.object.clone;

public class CloneExample {

	public static void main(String[] args) {
		Member member = new Member(
				"최기근", 
				28, 
				new int[] {100, 99, 95},
				new Car("캐스퍼")
				);
		System.out.println(member);
		Member cloned = member.getMember();
		System.out.println(cloned);
	}

}
