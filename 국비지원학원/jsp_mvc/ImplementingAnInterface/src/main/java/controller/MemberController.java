package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("*.mc")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService ms = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestPath = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestPath.substring(contextPath.length()+1);
		
		String nextPage = null;
		
		if(command.equals("login.mc")) {
			nextPage="/member/login.jsp";
		}
		
		if(command.equals("join.mc")) {
			nextPage="/member/join.jsp";
		}
		
		if(command.equals("logout.mc")) {
			// 로그 아웃 처리
			ms.logOut(request, response);
			nextPage = "/common/main.jsp";
		}
		if(nextPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String requestPath = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestPath.substring(contextPath.length()+1);
		
		if(command.equals("loginSubmit.mc")) {
			// 로그인 요청 처리
			if(ms.memberLogin(request, response)) {
				response.sendRedirect(request.getContextPath());
			}else {
				response.sendRedirect(request.getContextPath()+"/login.mc");
			}
		}
		
		if(command.equals("joinSubmit.mc")) {
			// 회원 가입 요청 처리
			ms.memberJoin(request, response);
			return;
		}
	}

}
