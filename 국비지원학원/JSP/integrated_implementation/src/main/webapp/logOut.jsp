<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:remove var="member" scope="session" />
<script>
	alert('로그아웃 완료');
	location.href="main.jsp";
</script>