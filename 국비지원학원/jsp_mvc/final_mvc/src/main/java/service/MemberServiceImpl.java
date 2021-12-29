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
	public void memberJoin(HttpServletRequest request, 
						   HttpServletResponse response) throws IOException {
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
		pw.println("</script>");
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
		// session 삭제 & cookie 정보 삭제
		HttpSession session = request.getSession();
		// 새로운 세션 객체 생성
		// session.invalidate();
		// 단일 속성 삭제
		session.removeAttribute("member");
		
		Cookie[] cookies = request.getCookies();
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

	@Override
	public void withDraw(HttpServletRequest request, HttpServletResponse response) {
		String tempPass =request.getParameter("tempPass");
		System.out.println("tempPass : " + tempPass);
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		String id = member.getId();
		// id 와 임시작성된 비밀번호가 일치하는 사용자 확인
		member = dao.memberLogin(id, tempPass);
		
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			if(member != null) {
				//회원정보 일치 삭제 진행
				dao.withDrawMember(member.getNum());
				
				//탈퇴한 회원의 session,cookie 정보 삭제
				logOut(request, response);
				out.print("alert('회원 탈퇴 완료');");
				out.print("location.href='test';");
			}else {
				//정보가 일치하지 않음
				out.print("alert('실패 ! 정보가 일치하지 않습니다.');");
				out.print("history.go(-1);	");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void memberUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberVO member = new MemberVO();
		member.setNum(Integer.parseInt(request.getParameter("num")));
		member.setPass(request.getParameter("pass"));
		member.setName(request.getParameter("name"));
		member.setGender(request.getParameter("gender"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		System.out.println("update member : " + member);
		
		boolean isUpdate = dao.memberUpdate(member);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String url = "update.mc";
		String msg = "수정 실패";
		out.print("<script>");
		if(isUpdate) {
			String id = request.getParameter("id");
			MemberVO updateMember = dao.getMemberById(id);
			request.getSession().setAttribute("member", updateMember);
			url = "info.mc";
			msg = "수정 완료";
		}
		out.print("alert('"+msg+"');");
		out.print("location.href='"+url+"';");
		out.print("</script>");
	}

	@Override
	public void findPassSubmit(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void changePassCode(HttpServletRequest requst, HttpServletResponse response) {

	}

	@Override
	public void changePass(HttpServletRequest requst, HttpServletResponse response) {

	}

}
