package guide;

import java.util.Iterator;

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
		String mId = sc.next().trim();
		if(!this.memberIdCheck(mId)) {
			System.err.println("이미존재하는 아이디입니다");
			return;
		}
		System.out.println("비밀번호를 입력해주세요 >");
		String mPw = sc.next().trim();
		System.out.println("비밀번호를 한번더 입력해주세요 >");
		String mPwCheck = sc.next().trim();
		if (!mPw.equals(mPwCheck)) {
			System.err.println("비밀번호가 일치하지 않습니다");
			return;
		}
		System.out.println("이름을 입력해주세요 >");
		String mName = sc.next().trim();
		int mNum = number;
		number++;
		long time =System.currentTimeMillis();
//		Date date = new Date(time);
		long reg = time;
		Member member = new Member(mNum, mName, mId, mPw, reg);
		System.out.println(member.toString());
		memberList.add(member);
	}

	@Override
	protected void login() {
		System.out.println("아이디를 입력해주세요 >");
		String mId = sc.next().trim();
		System.out.println("비밀번호를 입력해주세요 >");
		String mPw = sc.next().trim();
		Member m = new Member(mId, mPw);
		loginMember=findMember(m);
		if (loginMember == null) {
			System.err.println("일치하는 회원정보가 없습니다");
		}else if (loginMember.getmId() == "root") {
			System.err.println("정상적으로 로그인 되었습니다");
			System.err.println("관리자 계정입니다.");
		}else {
			System.err.println("정상적으로 로그인 되었습니다");
			System.out.println(loginMember.toString());
		}
	}

	@Override
	protected void select() {
		if (loginMember==null) {
			System.err.println("로그인후 이용하실수 있습니다");
		}else if (loginMember.getmId()=="root") {
			Iterator<Member> itr = memberList.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
		}else {
			System.err.println(loginMember.toString());
		}
	}

	@Override
	protected void update() {
		System.out.println("== 회원 정보 수정 ==");
		Iterator<Member> itr = memberList.iterator();
		if (loginMember==null) {
			System.err.println("로그인후 이용하실수 있습니다");
		}else if (loginMember.getmId()=="root") {
			System.out.println("== 관리자 회원 정보 수정 ==");
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
			System.out.println("수정할 회원의 번호를 입력해주세요 > ");
			int inputnum=sc.nextInt();
			Member member = null;
			String inputName = null;
			while (itr.hasNext()) {
				member = itr.next();
				if (member.getmNum()==inputnum) {
					System.out.println("수정할 회원의 이름을 다시 입력해주세요 > ");
					inputName = sc.next();
					member.setmName(inputName);
					break;
				}
			}
			System.err.println("수정완료");
		}else {
			System.out.println("= 내 정보 수정 =");
			System.out.println("비밀번호를 한번더 입력해주세요");
			if (loginMember.getmPw().equals(sc.next())) {
				System.out.println("수정할 이름을 입력해주세요");
				loginMember.setmName(sc.next());
				System.err.println(loginMember.toString());
			}else {
				System.out.println("비밀번호가 일치하지 않습니다");
				return;
			}
		System.err.println("수정이 완료되었습니다");
		}
		
	}

	@Override
	protected void delete() {
		if (loginMember==null) {
			System.err.println("로그인후 이용하실수 있습니다");
		}else if (loginMember.getmId()=="root") {
			System.err.println("회원정보를 삭제할 수 없습니다");
		}else {
			System.err.println("정말로 삭제하시겠습니까 ? y/n");
			char yesOrNo = sc.next().charAt(0);
			switch (yesOrNo) {
			case 'y': case 'Y' :
				deleteMember();
				break;
			case 'n': case 'N' :
				System.out.println("취소합니다");
				return;
			default:
				System.out.println("잘못된 입력입니다 삭제를 취소합니다");
				return;
			}
		}
	}

	@Override
	protected void deleteMember() {
		memberList.remove(loginMember);
		loginMember=null;
		System.err.println("삭제완료");
	}

}
