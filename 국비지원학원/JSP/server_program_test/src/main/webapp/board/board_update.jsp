<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<s:query var="rs" dataSource="jdbc/MySqlDB">
	SELECT * FROM test_board 
	WHERE board_num = ?
	<s:param>${param.board_num}</s:param>
</s:query>
<c:forEach var = "row" items = "${rs.rows}">
	<jsp:useBean id="updateArticle" class="vo.TestBoardVO" />
	<jsp:setProperty property="board_content" name="updateArticle" value="${row.board_content}"/>	
	<jsp:setProperty property="board_name" name="updateArticle" value="${row.board_name}"/>
	<jsp:setProperty property="board_title" name="updateArticle" value="${row.board_title}"/>
</c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>게시물 수정</h1>
	<form action="board_update_submit.jsp" method="post">
		<input type="hidden" name="board_num" value="${param.board_num}"/>
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="board_name" value="${updateArticle.board_name}" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="board_pass" required/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="board_title" value="${updateArticle.board_title}"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows=10 cols=40 name="board_content">${updateArticle.board_content}</textarea></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="수정완료"/></td>
			</tr>
		</table>
	</form>
</body>
</html>