package c5_comparable;

import java.util.TreeSet;

public class ComparableExample {

	public static void main(String[] args) {
		/*
		 * 객체 검색 -Comparable 인터페이스가 구현되어있어야 가능
		 * 정렬기준을 잡아주는 Comparavle Interface
		 * 
		 * 현재 객체 < 파라미터로 넘어온 객체 : 음수 리턴
		 * 현재 객체 == 파라미터로 넘어온 객체 : 0 리턴
		 * 현재 객체 > 파라미터로 넘어온 객체 : 양수 리턴
		 * 음수 또는 0 이면 객체의 자리를 그대로 유지
		 * 양수인 경우에는 두 객체의 자리를 변경
		 */
		
		TreeSet<String> stringSet = new TreeSet<>();
		stringSet.add("나라가");
		stringSet.add("가가가");
		stringSet.add("가나다");
		stringSet.add("가각가");
		System.out.println(stringSet);
		
		System.out.println("=============================");
		TreeSet<Person> set	 = new TreeSet<>();
		set.add(new Person("최기근", 26));
		set.add(new Person("심현석", 300));
		set.add(new Person("김재관", 30));
		set.add(new Person("홍길동", 65)); // 트리셋은 자동 정렬이 이루어지는 데 Person 객체 정렬 기준을 모른다 ! 그래서 오류발생
		System.out.println(set); //implements Comparable<Person>, 해서 compareTo 오버라이딩 해서 오류안남
	}

}
