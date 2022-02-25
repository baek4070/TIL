package net.koreate.sec.dao;

import java.util.List;

import net.koreate.sec.vo.ValidationMemberVO;

public interface MemberDAO {
	
	void memberJoin(ValidationMemberVO vo);

	ValidationMemberVO getMemberByID(String u_id) throws Exception;

	// 회원가입한 회원 기본 권한 추가 ROLE_USER
	void insertAuth(String u_id) throws Exception;

	// 로그인 시 최종 방문 시간을 현재시간으로 수정
	void updateVistDate(String u_id)throws Exception;

	// 등록된 사용자 리스트
	List<ValidationMemberVO> getMemberList()throws Exception;
	
	
}









