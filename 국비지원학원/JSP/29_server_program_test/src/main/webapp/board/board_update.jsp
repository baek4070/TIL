<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<s:query dataSource="jdbc/MySqlDB" var="rs">
	SELECT * FROM test_board WHERE board_num = ${param.board_num}
</s:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 수정</h1>
	<form action="board_update_submit.jsp" method="post">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="board_name" value="${rs.rows[0].board_name}"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="board_pass" required/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="board_title" value="${rs.rows[0].board_title}"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="board_content" rows=10 cols=40>${rs.rows[0].board_content}</textarea></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="수정완료"/></td>
			</tr>
		</table>
		<input type="hidden" name="board_num" value="${param.board_num}"/>
	</form>
</body>




</html>

