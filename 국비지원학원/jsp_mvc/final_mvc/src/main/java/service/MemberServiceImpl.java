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
	public void memberJoin(HttpServletRequest request, HttpServletResponse response) throws IOException {
         String id = request.getParameter("id");
         String pass = request.getParameter("pass");
         String rePass = request.getParameter("rePass");
         String name = request.getParameter("name");
         int age = Integer.parseInt(request.getParameter("age"));
         String gender = request.getParameter("gender");
         
         MemberVO vo = new MemberVO(id,pass,name,age,gender);
         
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
         pw.print("</script>");
	}

	@Override
	public boolean memberLogin(HttpServletRequest request, HttpServletResponse response) {
		boolean isLogin = false;
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String check = request.getParameter("check");
		
		MemberVO member = dao.memberLogin(id, pass);
		if(member != null) {
			isLogin = true;
			HttpSession session = request.getSession();
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
	public void logOut(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void withDraw(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void memberUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	@Override
	public void findPassSubmit(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void changePassCode(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void changePass(HttpServletRequest request, HttpServletResponse response) {

	}

}
