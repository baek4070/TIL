package d.cooperation;

public class MemberDAO implements DatabaseAccessObject{

	@Override
	public void connection() {
		System.out.println("데이터베이스 연결");
	}

	@Override
	public void select() {
		System.out.println("데이터베이스 선택");
	}

	@Override
	public void insert() {
		System.out.println("데이터베이스 입력");
	}

	@Override
	public void update() {
		System.out.println("데이터베이스 수정");
	}

	@Override
	public void delete() {
		System.out.println("데이터베이스 삭제");
	}

	@Override
	public void close() {
		System.out.println("데이터베이스 종료");
	}

}
