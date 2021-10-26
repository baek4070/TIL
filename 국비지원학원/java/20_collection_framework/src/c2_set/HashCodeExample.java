package c2_set;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExample {

	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		String name1 = "최기근";
		String name2 = "최기근";
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		System.out.println(name1.equals(name2)); // 완전 중복인걸 알수있다
		names.add(name1);
		names.add(name2); // 동일한 객체는 중복저장하지 않는다
		System.out.println(names.size());
		System.out.println(names);
		
		Member member1 = new Member(name1, 20);
		Member member2 = new Member(name2, 22);
		Member member3 = new Member(name1, 20);
		System.out.println(member1.hashCode());
		System.out.println(member2.hashCode());
		System.out.println(member3.hashCode());
		
		Set<Member> setMember = new HashSet<>();
		setMember.add(member1);
		setMember.add(member2);
		setMember.add(member3);
		System.out.println(setMember.size());
		System.out.println(setMember);
	}

}
