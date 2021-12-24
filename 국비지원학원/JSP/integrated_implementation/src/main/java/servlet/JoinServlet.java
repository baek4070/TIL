package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberVO;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberVO member = new MemberVO();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		
		member.setId(id);
		member.setPass(pass);
		member.setName(name);
		member.setAddr(addr);
		member.setPhone(phone);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();
		ArrayList<MemberVO> getList = (ArrayList)application.getAttribute("memberList");
		
		if( getList == null) {
			ArrayList<MemberVO> memberList = new ArrayList<>();
			memberList.add(member);
			application.setAttribute("memberList", memberList);
			System.out.println(memberList);
			out.println("<script>");
			out.println("alert('회원가입 완료!');");
			out.println("location.href=\"main.jsp?page=login\";");
			out.println("</script>");
			out.flush();
		}else {
			for(MemberVO m : getList) {
				if(m.getId().equals(id)){
					System.out.println("joinMember :"+member);
					System.out.println(m);
					out.println("<script>");
					out.println("alert('이미 존재하는 사용자 아이디 입니다');");
					out.println("history.go(-1);");
					out.println("</script>");
					out.flush();
					return;
				}
			}
			getList.add(member);
			application.setAttribute("memberList", getList);
			for(MemberVO m : getList) {
			System.out.println(m);
			}
			out.println("<script>");
			out.println("alert('회원가입 완료!');");
			out.println("location.href=\"main.jsp?page=login\";");
			out.println("</script>");
			out.flush();
			
		}
		
		
	}

}
