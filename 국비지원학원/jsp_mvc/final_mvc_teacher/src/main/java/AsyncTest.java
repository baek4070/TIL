

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.test")
public class AsyncTest extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd 
		= request.getRequestURI().substring(
				request.getContextPath().length()+1
		  );
		String nextPage = null;
		if(cmd.equals("javascript.test")) {
			nextPage = "/test/javascript.jsp";
		}else if(cmd.equals("jQuery.test")) {
			nextPage = "/test/jquery.jsp";
			
		}else if(cmd.equals("user.test")) {
			System.out.println("sample test");
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			System.out.println("name : " + name);
			System.out.println("age : " + age);
			// JSON
			// javascript Object Notation
			// 자바스크립트 오브젝트 타입의 경량 data
			// 사람이 읽고 쓰기도 편하고 기계가 분석하고 생성하기도 용이
			response.setContentType("application/json;charset=utf-8");
			// var obj = { key:value , key : value}
			String json = "{'name': '"+name+"' , 'age' : '"+age+"'}";
			System.out.println(json);
			response.getWriter().print(json);
		}
		
		
		
		if(nextPage != null) {
			request.getRequestDispatcher(nextPage)
			.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
