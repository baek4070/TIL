<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSession.jsp</title>
</head>
<body>
	<%
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		out.println(vo);
	%>
	<br/>
	<a href="member.jsp">돌아가기</a>
</body>
</html>