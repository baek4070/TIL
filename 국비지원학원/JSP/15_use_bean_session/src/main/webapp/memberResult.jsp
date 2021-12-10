<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberResult.jsp</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8"); //포스트 방식 인코딩 설정 먼저
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		vo.MemberVO vo = new vo.MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setEmail(email);
		vo.setAddr(addr);
		session.setAttribute("vo", vo); //"vo"라는 이름으로 vo 객체를 session에 저장
	%>
	
	<%=session.getAttribute("vo") %>	
	<br/>
	<!-- jsp가 바뀌어도 session이 유지되는거 확인 -->
	<a href="memberSession.jsp">session 확인</a> 
</body>
</html>