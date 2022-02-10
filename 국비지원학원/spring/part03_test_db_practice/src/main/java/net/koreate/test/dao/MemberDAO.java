package net.koreate.test.dao;

import java.util.List;

import net.koreate.test.vo.MemberVO;

public interface MemberDAO {
	//회원 정보 삽입
	void insertMember(MemberVO vo);
	
	MemberVO readMember(String userid);
	
	List<MemberVO> readMemberList();
}
