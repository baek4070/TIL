<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Cookie cookie = new Cookie("u_id","");
	cookie.setPath("/");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
%>
<c:remove var="member" scope="session" />
<script>
	alert('로그아웃 완료');
	location.href="main.jsp";
</script>