<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyPage.jsp</title>
</head>
<body>
	<h1>
		<a href="${pageContext.request.contextPath}">HOME</a>
	</h1>
	<h3>MODIFY BOARD</h3>
	<form id="modifyForm" action="modifyPage" method="POST">
		<input type="hidden" name="uno" value="${userInfo.uno}"/>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${board.title}" required /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${sessionScope.userInfo.uname}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" rows="30" cols="50">${board.content}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="saveBtn" value="등록" />
				</td>
			</tr>
		</table>
		<input type="hidden" name="bno" value="${board.bno}"/>
		<input type="hidden" name="page" value="${cri.page}"/>
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}"/>
		<input type="hidden" name="searchType" value="${cri.searchType}"/>
		<input type="hidden" name="keyword" value="${cri.keyword}"/>
	</form>
<script src="http://code.jquery.com/jquery-latest.min.js" ></script>
<script>
	$("#saveBtn").click(function(){
		$("#modifyForm").submit();
	});
</script>
</body>
</html>
























