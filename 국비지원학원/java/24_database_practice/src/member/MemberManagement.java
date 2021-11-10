package member;

public class MemberManagement extends AppBase{

	@Override
	protected void isRun() {
		while(isRun) {
			System.out.println("=========================================================");
			System.out.println("1.회원가입 | 2.로그인 |3.회원정보 | 4.회원정보수정 |5.회원탈퇴 |6.종료" );
			System.out.println("=========================================================");
			System.out.println("메뉴 선택 > ");
			
			selectNo = sc.nextInt();
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void select() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void delete() {
		// TODO Auto-generated method stub
		
	}

}
