<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listPage.jsp</title>
</head>
<body>
	<h3>BOARD LIST PAGE</h3>
	<form action="register" method="GET">
		<button>NEW BOARD</button>
	</form>
	<hr/>
	<table border=1>
		<tr>
			<th>BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th>VIEWCNT</th>
		</tr>
		<!-- 게시글 목록 -->
		
		<!-- 페이징 블럭 -->
		
	</table>
</body>
</html>








