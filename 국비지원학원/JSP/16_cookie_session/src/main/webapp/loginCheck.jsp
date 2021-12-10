<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="joinMember" 
				class="vo.UserVO" 
				scope="application"/>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String login = request.getParameter("login");
		String message = "";
		String nextPage = "";
		if(joinMember.getId() != null 
				&&
		   id.equals(joinMember.getId()) 
		   		&&
	   	   pw.equals(joinMember.getPw())){
			// 로그인 성공
			session.setAttribute("loginMember", joinMember);
			message = "로그인 성공!";
			nextPage = "index.jsp";
			
			if(login != null){
				Cookie cookie = new Cookie("id",id);
				cookie.setMaxAge(60*60*24*30);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			
		}else{
			// 로그인 실패
			message = "로그인 실패!";
			nextPage = "login.jsp";
		}
		
		out.print("<script>");
		out.print("alert('"+message+"');");
		out.print("location.href='"+nextPage+"';");
		out.print("</script>");
	%>
</body>
</html>











