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
		System.out.println(member.hashCode());// 주소값이 다른거 확인
		System.out.println(cloned.hashCode());//
		
		cloned.score[0] = 90; // 복제된 객체의 필드값 변경
		cloned.car.model ="소나타";
		cloned.name="심현석";
		
		System.out.println(cloned); // 복제된 객체의 값을 변경했는데 원본 필드값도 변경되었음
		System.out.println(member); // 주소값을 복제 저장하기떄문에 같은곳을 참조하고 있기때문
	}

}
