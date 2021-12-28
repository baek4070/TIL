package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	// 회원 가입 처리
	void memberJoin(HttpServletRequest request,
			HttpServletResponse response) throws IOException;
	
	// 로그인 처리
	/**
	 * @return true = 로그인성공 , false 로그인실패
	 */
	boolean memberLogin(HttpServletRequest request,
			HttpServletResponse response);
	
	// 로그아웃 처리
	void logOut(HttpServletRequest request,
			HttpServletResponse response);
	
	// 회원 탈퇴 처리
	void withDraw(HttpServletRequest request,
			HttpServletResponse response);
	
	// 회원 정보 수정
	void memberUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException;
	
	/**
	 * 비밀번호 찾기
	 */
	/**
	 * @param request id(email) , name(사용자 이름) 
	 * @param response - 인증 - 메일 전송
	 */
	void findPassSubmit(HttpServletRequest request,
			HttpServletResponse response);
	
	/**
	 * @param request id(email), code
	 * @param response - 인증 - 비밀번호 변경 페이지 이동
	 */
	void changePassCode(HttpServletRequest request,
			HttpServletResponse response);
	
	/**
	 * @param requst - id(email) , code , pass
	 * @param response - 비밀번호 변경 - login
	 */
	void changePass(HttpServletRequest request,
			HttpServletResponse response);
}













