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
import javax.servlet.http.HttpSession;

import dto.LoginDTO;
import vo.MemberVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LoginDTO loginMember = new LoginDTO();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String login = request.getParameter("login");
		
		loginMember.setId(id);
		loginMember.setPass(pass);
		loginMember.setLogin(login);
		
		System.out.println("id : "+id+", pw : null, login : "+login);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();
		ArrayList<MemberVO> getList = (ArrayList)application.getAttribute("memberList");
		
		if( getList == null) {
			out.println("<script>");
			out.println("alert('일치하는 회원정보가 없습니다!');");
			out.println("location.href=\"main.jsp?page=login\";");
			out.println("</script>");
			out.flush();
		}else {
			for(MemberVO m : getList) {
				if(m.getId().equals(id)&&m.getPass().equals(pass)){
					HttpSession session = request.getSession();
					session.setAttribute("member", m);
					out.println("<script>");
					out.println("alert('로그인 성공');");
					out.println("location.href=\"main.jsp\";");
					out.println("</script>");
					out.flush();
					return;
				}
			}
			out.println("<script>");
			out.println("alert('일치하는 회원정보가 없습니다!');");
			out.println("location.href=\"main.jsp?page=login\";");
			out.println("</script>");
			out.flush();
			
		}
	}

}
