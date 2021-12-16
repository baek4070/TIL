<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메시지 삭제 확인</title>
</head>
<body>
	<!-- 삭제 요청에 필요한 정보 전달 -->
	<%
	request.setCharacterEncoding("utf-8");
	String num = request.getParameter("id");
	%>
	<form action="guestbook_delete.jsp" method="POST">
		메시지를 삭제하시려면 암호를 입력하세요:<br/>
		암호:<input type="password" name="password"/><br/>
		<input type = "hidden" name="id" value="<%=num%>"/>
		<button>메시지 삭제하기</button>
	</form>
</body>
</html>
