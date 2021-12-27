<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<s:query dataSource="jdbc/MySqlDB" var="rs">
	SELECT * FROM test_board WHERE board_num = ${param.board_num}
</s:query>
<jsp:useBean id="board" class="vo.TestBoardVO" />
<jsp:setProperty name="board" property="board_num" value="${param.board_num}"/>
<jsp:setProperty name="board" property="board_name" value="${rs.rows[0].board_name}"/>
<jsp:setProperty name="board" property="board_title" value="${rs.rows[0].board_title}"/>
<jsp:setProperty name="board" property="board_content" value="${rs.rows[0].board_content}"/>

<s:update dataSource="jdbc/MySqlDB">
	UPDATE test_board SET 
	board_readcount = board_readcount + 1 
	WHERE board_num = ${param.board_num} 
</s:update>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 상세내용</h1>
	<table>
		<tr>
			<td>작성자</td>
			<td>${board.board_name}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${board.board_title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea readonly cols=40 rows=10>${board.board_content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan=2>
				<a href="board_update.jsp?board_num=${param.board_num}">[수정]</a>
				<a href="board_delete.jsp?board_num=${param.board_num}">[삭제]</a>
				<a href="board_list.jsp">[목록]</a>
			</td>
		</tr>
	</table>
</body>
</html>