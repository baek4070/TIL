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

	// 멤버 관리 번호
	private int count = 1;
	
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
		while (isRun) {
			System.out.println("===================================================");
			System.out.println("1.회원가입|2.로그인|3.회원목록|4.회원정보수정|5.회원탈퇴|6.종료");
			System.out.println("===================================================");
			System.out.println("번호입력 > ");
			selectNo = sc.nextInt();
			switch (selectNo) {
			case 1:
				join();
				break;
			case 2:
				login();
				break;
			case 3:
				select();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
				break;
			case 6:
				terminate();
				break;
			default:
				System.out.println("등록된 메뉴가 아닙니다");
			}
		}
	}
	
	// 프로그램 종료
	private void terminate() {
		System.out.println("6.종료");
		isRun = false;
		System.out.println("프로그램 종료");
	}

	// 회원 가입
	private void join() {
		System.out.println("1.회원가입");
		System.out.println("아이디를 입력해주세요>");
		String mId = sc.next();
		System.out.println("비밀번호를 입력해주세요>");
		String mPw = sc.next();
		System.out.println("비밀번호를 확인해주세요>");
		String mPwCheck = sc.next();
		System.out.println("이름을 입력해주세요>");
		String mName = sc.next();
		if (mPw.equals(mPwCheck) && memberIdCheck(mId)) {
			for (int i = 0; i < this.members.length; i++) {
				if (members[i] == null) {
					members[i] = new Member(count, mName, mId, mPw);
					System.out.println("회원가입이 완료 되었습니다");
					count++;
					break;
				}
			}
		}else {
			System.out.println("이미 사용중이거나 비밀번호가 일치하지 않습니다");
		}
	}
	
	// 로그인
	private void login() {
		System.out.println("2.로그인");
		System.out.println("아이디를 입력해주세요>");
		String mId = sc.next();
		System.out.println("비밀번호를 입력해주세요>");
		String mPw = sc.next();
		Member member = new Member(mId, mPw);
		loginMember = findMember(member);
			if (findMember(member) != null) {
				System.out.println("정상적으로 로그인 되었습니다");
				System.out.println(loginMember.toString());
				if (loginMember.equals(master)) {
					System.out.println("관리자 계정입니다.");
				}
			}else {
				System.out.println("일치하는 멤버가 없습니다");
			}
	}

	// 회원목록 - 로그인한 회원이 관리자 일때만 노출 
	private void select() {
		System.out.println("3.회원목록");
		if (loginMember==null) {
			System.out.println("관리자만 확인가능한 메뉴입니다.");
			return;
		}
		if (loginMember.equals(master)) {
			for (int i = 0; i < members.length; i++) {
				if (members[i]!=null) {
					System.out.println(members[i].toString());
				}
			}
		}else {
			System.out.println("관리자만 확인가능한 메뉴입니다.");
		}
	}
	
	// 회원정보 수정 - 로그인한 회원 정보랑 일치 하거나 관리자 일때만 수정(이름정보만 수정)
	private void update() {
		System.out.println("4.회원정보수정");
		if (loginMember==null) {
			System.out.println("로그인후 이용가능합니다.");
			return;
		}
		if (loginMember.equals(master)) {
			System.out.println("== 회원정보수정 ==");
			System.out.println("==관리자 회원정보 수정");
			for (int i = 0; i < members.length; i++) {
				if (members[i]!=null) {
					System.out.println(members[i].toString());
				}
			}
			System.out.println("수정할 회원번호를 입력해주세요.");
			int mNum = sc.nextInt();
			for (int i = 0; i < members.length; i++) {
				if (members[i]!=null && members[i].getmNum() == mNum) {
					System.out.println("수정할 회원 이름을 입력해주세요");
					String mName = sc.next();
					members[i].setmName(mName);
					System.out.println("수정완료");
				}
			}
		}else if(loginMember!=null) {
			System.out.println("비밀번호를 한번더 입력해주세요 >");
			String nPw = sc.next();
			if (loginMember.getmPw().equals(nPw)) {
				System.out.println("수정할 회원 이름을 입력해주세요");
				String mName = sc.next();
				loginMember.setmName(mName);
				System.out.println("내정보 수정완료");
			}else {
				System.out.println("비밀번호가 일치하지 않습니다");
			}
		}else {
			System.out.println("로그인후 이용가능합니다");
		}
	}
	
	// 회원탈퇴 - 삭제 할려는 정보가 본인 정보일때만 삭제
	private void delete() {
		System.out.println("5.회원탈퇴");
		if (loginMember==master) {
			System.out.println("master 계정은 삭제할수 없습니다.");
		}else if(loginMember!=null) {
			System.out.println("비밀번호를 한번더 입력해주세요 >");
			String nPw = sc.next();
			if (loginMember.getmPw().equals(nPw)) {
				System.out.println("정말로 탈퇴하시겠습니다? y/n");
				char answer = sc.next().charAt(0);
				if (answer == 'y' || answer == 'Y') {
					deleteMember();
				}else {
					System.out.println("취소합니다");
				}
			}else {
				System.out.println("비밀번호가 일치하지 않습니다");
			}
		}else {
			System.out.println("로그인후 이용가능합니다");
		}
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
