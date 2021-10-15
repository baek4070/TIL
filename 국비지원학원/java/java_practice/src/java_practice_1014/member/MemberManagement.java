package java_practice_1014.member;

import java.util.Scanner;

public class MemberManagement{

	// 사용자 입력
	private Scanner sc = new Scanner(System.in);
	
	// 회원정보 저장
	private Member[] members = new Member[100];
	
	// 관리자 계정
	private Member master = new Member(100,"master","root","root");
	
	// 로그인한 회원
	private Member loginMember = null;
	
	// 프로그램 flag (true : 진행 , false : 종료) 
	private boolean isRun = true;
	
	// 메뉴 번호 선택
	private int selectNo;

	// 프로그램 실행용 생성자
	public MemberManagement() {
		members[members.length-1] = master;
		isRun();
	}
	
	/*
	 * 기능 관리 
	 */
	
	// 프로그램 실행
	private void isRun() {
		
	}
	
	// 프로그램 종료
	private void terminate() {
		
	}

	// 회원 가입
	private void join() {
		
	}
	
	// 로그인
	private void login() {
		
	}

	// 회원목록 - 로그인한 회원이 관리자 일때만 노출 
	private void select() {
		
	}
	
	// 회원정보 수정 - 로그인한 회원 정보랑 일치 하거나 관리자 일때만 수정(이름정보만 수정)
	private void update() {
		
	}
	
	// 회원탈퇴 - 삭제 할려는 정보가 본인 정보일때만 삭제
	private void delete() {
		
	}
	
	// 사용자 아이디 중복 체크
	private boolean memberIdCheck(String mId) {
		for(Member m : members) {
			if(m != null && m.getmId().equals(mId)) {
				return false;
			}
		}		
		return true;
	}
	
	// 회원 아이디와 비밀번호로 회원 찾기
	private Member findMember(Member m) {
		for(Member member : members) {
			if(member != null && member.equals(m)) {
				return member;
			}
		}
		return null;
	}
	
	// 회원 정보 삭제
	private void deleteMember() {
		for(int i=0; i<members.length; i++) {
			if(members[i].equals(loginMember)) {
				members[i] = null;
				loginMember = null;
				System.out.println("회원탈퇴 완료");
				return;
			}
		}
	}
}
