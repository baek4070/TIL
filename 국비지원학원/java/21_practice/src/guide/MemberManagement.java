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
		}
	}

	@Override
	protected void terminate() {
	}

	@Override
	protected void join() {
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
