package member;

import dao.MemberDAO;

public class MemberManagement extends AppBase{
	
	protected MemberManagement(MemberDAO dao) {
		super(dao);
	}

	@Override
	protected void isRun() {
		while(isRun) {
			System.out.println("=========================================================");
			System.out.println("1.회원가입 | 2.로그인 |3.회원정보 | 4.회원정보수정 |5.회원탈퇴 |6.종료" );
			System.out.println("=========================================================");
			selectNo = getNumberData("메뉴 선택 > ");
			
			switch(selectNo) {
			case 1 :
				System.out.println("== 회원가입 == ");
				join();
				break;
			case 2 :
				System.out.println("== 로그인 == ");
				login();
				break;
			case 3 :
				System.out.println("== 회원목록 == ");
				select();
				break;
			case 4 :
				System.out.println("== 회원정보수정 == ");
				update();
				break;
			case 5 :
				delete();
				System.out.println("== 회원탈퇴 == ");
				break;
			case 6 :
				System.out.println("== 프로그램 종료 == ");
				terminate();
				break;
			default :
				System.out.println("해당 메뉴가 존재 하지 않습니다.");
			}
		}
	}

	@Override
	protected void terminate() {
		isRun = false;
	}

	@Override
	protected void join() {
		/*
		 * mId - 중복아이디는 가입 불가
		 * mPw == rePw - 비밀번호가 일치하면 통과
		 * mName - 사용자 이름
		 * 회원정보 등록
		 * 완료 시 등록된 회원 정보를 넘겨받아 출력 
		 */
	}

	@Override
	protected void login() {
		/*
		 * mId 아이디
		 * mPw 비밀번호
		 * 아이디와 비밀번호가 일치하는 사용자가 존재할때
		 * 로그인 처리 - loginMember
		 */
	}

	// 회원 목록 - 로그인한회원(loginMember)
	// 관리자 - 전체회원목록 출력
	// 일반회원 - 자기자신의 정보만 출력
	// 비로그인 - 권한이없다고 출력
	@Override
	protected void select() {
		
	}

	/*
	 * 회원정보 수정
	 * 로그인한 회원정보랑 일치하는지 비밀번호 확인
	 * 일치하는 사용자는 자기자신의 정보 수정
	 * 
	 * 관리자 일 경우 회원 번호로 이름정보를 수정
	 * 
	 * 비로그인은 권한이 없다고 출력
	 */
	@Override
	protected void update() {
		
	}

	/*
	 * 회원탈퇴 - 삭제할려는 정보가 본인 정보와 일치할때만 삭제
	 * - 관리자 계정은 삭제 불가
	 * - 삭제 여부를 확인하여 확인 되었을때만 삭제
	 * - 삭제된 회원 정보는 backup table에 저장 
	 */
	@Override
	protected void delete() {}

}