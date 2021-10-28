package guide;

public class MemberManagement extends AppBase
{
	
	public MemberManagement() {
		super();
	}

	@Override
	protected void isRun() {
		System.out.println("프로그램 시작!");
		while (isRun) {
			System.out.println("===================================================");
			System.out.println("1.회원가입|2.로그인|3.회원정보|4.회원정보수정|5.회원탈퇴|6.종료");
			System.out.println("===================================================");
			int choice = sc.nextInt();
			switch (choice) {
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
				System.out.println("종료합니다");
				isRun = false;
				break;
			default:
				System.out.println("잘못된 입력입니다");
				break;
			}
		}
	}

	@Override
	protected void terminate() {
	}

	@Override
	protected void join() {
		System.out.println("== 회원가입 ==");
		System.out.println("아이디를 입력해주세요 >");
		String id = sc.next().trim();
		System.out.println("비밀번호를 입력해주세요 >");
		System.out.println("비밀번호를 한번더 입력해주세요 >");
		System.out.println("이름을 입력해주세요 >");
	}

	@Override
	protected void login() {
	}

	@Override
	protected void select() {
	}

	@Override
	protected void update() {
	}

	@Override
	protected void delete() {
	}

	@Override
	protected void deleteMember() {
	}

}
