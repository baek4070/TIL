package a.object.equals;

import java.util.Scanner;

public class MemberExam {

	public static void main(String[] args) {
		Member member = new Member("id001");
		Scanner sc = new Scanner(System.in);
		System.out.println("ID를 입력해주세요");
		String id = sc.next();
		Member loginMember = new Member(id);
		if(member == loginMember) {
			System.out.println("일치하는 회원입니다.");
		}else {
			System.out.println("회원정보가 일치하지 않습니다");
		}
		
		if (member.equals(loginMember)) {
			System.out.println("논리적으로 일치하는 회원입니다.");
		}else {
			System.out.println("논리적으로 일치하지 않는 회원입니다.");
		}
	}
}
