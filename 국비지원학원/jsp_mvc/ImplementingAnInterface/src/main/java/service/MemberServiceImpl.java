package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO dao = new MemberDAOImpl();

	@Override
	public void memberJoin(HttpServletRequest requst, HttpServletResponse response) throws IOException {
		String id = requst.getParameter("id");
		String pass = requst.getParameter("pass");
		String rePass = requst.getParameter("rePass");
		String name = requst.getParameter("name");
		
		MemberVO vo = new MemberVO(id,pass,name);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("<script>");
		if(!pass.equals(rePass)) {
			pw.print("alert('비밀번호가 일치하지 않습니다.');");
			pw.print("history.go(-1);");
			pw.print("</script>");
			return;
		}
		// id로 사용자 정보 찾기
		MemberVO member = dao.getMemberById(id);
		if(member != null) {
			pw.print("alert('이미 사용중인 아이디 입니다.');");
			pw.print("history.go(-1);");
			pw.print("</script>");
			return;
		}
		
		boolean isSuccess = dao.memberJoin(vo);
		if(isSuccess) {
			pw.print("alert('회원가입 성공');");
			pw.print("location.href='login.mc';");
		}else {
			pw.print("alert('회원가입 실패');");
			pw.print("history.back();");
		}
		pw.println("</script>");
	}

	@Override
	public boolean memberLogin(HttpServletRequest requst, HttpServletResponse response) {
		boolean isLogin = false;
		String id = requst.getParameter("id");
		String pass = requst.getParameter("pass");
		String check = requst.getParameter("check");
		
		MemberVO member = dao.memberLogin(id, pass);
		if(member != null) {
			isLogin = true;
			HttpSession session = requst.getSession();
			session.setAttribute("member", member);
			if(check != null) {
				Cookie cookie = new Cookie("id",member.getId());
				cookie.setMaxAge(60*60*24*15);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		return isLogin;
	}

	@Override
	public void logOut(HttpServletRequest requst, HttpServletResponse response) {
		// session 삭제 & cookie 정보 삭제
		HttpSession session = requst.getSession();
		// 새로운 세션 객체 생성
		// session.invalidate();
		// 단일 속성 삭제
		session.removeAttribute("member");
		
		Cookie[] cookies = requst.getCookies();
		if(cookies != null) {
			for(int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("id")) {
					Cookie cookie = new Cookie("id","");
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
			}
		}
	}

}
