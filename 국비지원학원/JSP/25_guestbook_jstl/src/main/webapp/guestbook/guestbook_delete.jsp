<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
	<title>방명록 메시지 삭제함</title>
</head>
<body>
<br/>
<f:requestEncoding value="utf-8" />
<c:choose>
	<c:when test="${empty param.id or empty param.password}">
		<script>
			alert("잘못된 접근 입니다.");
			history.go(-1);
		</script>
	</c:when>
	<c:otherwise>
		<s:update var="result" dataSource="jdbc/MySqlDB">
			DELETE FROM test_guestbook WHERE id = ? AND password = ? 
			<s:param>${param.id}</s:param>
			<s:param>${param.password}</s:param>
		</s:update>
	</c:otherwise>
</c:choose>
<!-- 삭제 확인 처리  알림 code 작성-->
<c:choose>
	<c:when test="${!empty result and result > 0}">
		<h3>삭제 성공</h3>
	</c:when>
	<c:otherwise>
		<h3>삭제 실패</h3>
	</c:otherwise>
</c:choose>
<a href="guestbook_list.jsp">[목록 보기]</a>
</body>
</html>











