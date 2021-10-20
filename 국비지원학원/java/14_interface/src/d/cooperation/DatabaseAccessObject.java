package d.cooperation;

public interface DatabaseAccessObject {
	// DB 연결 기능 구현
	void connection();
	void select();		//디비 정보 검색 기능
	void insert();		//디비 정보 삽입(추가)
	void update(); 		//디비 정보 수정
	void delete();		//디비 정보 삭제
	void close(); 		//디비 연결 종료
}
