<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<f:requestEncoding value="utf-8"/>
<jsp:useBean id="gb" class="vo.GuestBook" scope="page"/>
<jsp:setProperty name="gb" property="*"/>
<c:set var="msg" value="방명록 등록 실패"/>
<c:catch var="e">
	<s:update var="result" dataSource="jdbc/MySqlDB">
		INSERT INTO test_guestbook(guestName,password,message) 
		VALUES(?,?,?) 
		<s:param>${gb.guestName}</s:param>
		<s:param>${gb.password}</s:param>
		<s:param>${gb.message}</s:param>
	</s:update>
	<c:if test="${result > 0}">
		<c:set var="msg" value="방명록 등록 성공"/>
	</c:if>
</c:catch>
<c:if test="${!empty e}">
	<c:set var="msg" value="방명록 등록 실패 - ${e.message}"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
	<title>방명록 메시지 작성 확인</title>
</head>
<body>
<!-- 방명록 작성 후 처리 결과 출력 code 작성 -->
<h3>${msg}</h3>
<!-- 방명록 작성 후 처리 결과 출력 code 작성 end-->
<a href="guestbook_list.jsp">[목록 보기]</a>
</body>
</html>




