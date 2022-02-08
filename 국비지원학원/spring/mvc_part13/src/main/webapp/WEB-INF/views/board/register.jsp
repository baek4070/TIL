<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<a href="${pageContext.request.contextPath}">HOME</a>
	</h1>
	<h3>REGISTER BOARD</h3>
	<form id="registerForm" action="register" method="POST">
		<input type="hidden" name="uno" value="${userInfo.uno}"/>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" required /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${sessionScope.userInfo.uname}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" rows="30" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="saveBtn" value="등록" />
				</td>
			</tr>
		</table>
	</form>
<script src="http://code.jquery.com/jquery-latest.min.js" ></script>
<script>
	$("#saveBtn").click(function(){
		$("#registerForm").submit();
	});
</script>
</body>
</html>
























