<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>

<jsp:useBean id="pm" class="util.PageMaker" />
<c:set target="${pm}" property="displayPageNum" value="5"/>
<c:set target="${pm.cri}" property="perPageNum" value="5"/>

<!-- 사용자가 요청한 페이지(selectPage) 정보 -->
<c:if test ="${!empty param.selectPage}">
	<c:set target="${pm.cri}" property="page" 
				value="${param.selectPage}"/>
</c:if> 
<!-- 전체 게시물 수 -->
<s:query var="r" dataSource="jdbc/MySqlDB">
	SELECT count(*) AS count FROM test_board 
</s:query>
<c:set target="${pm}" property="totalCount" value="${r.rows[0].count}"/>

<!-- pageMaker 처리 완료 -->

<s:query var="rs" dataSource="jdbc/MySqlDB" 
startRow="${pm.cri.startRow}" maxRows="${pm.cri.perPageNum}">
	SELECT * FROM test_board 
	ORDER BY board_num DESC
</s:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<a href="board_write.jsp">게시글 작성하러 가기</a>
	<table border=1>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
		</tr>
		<!-- 게시글 목록 -->
		<c:forEach var="row" items="${rs.rows}">
			<tr>
				<td>${row['board_num']}</td>
				<td>
					<a href="board_detail.jsp?board_num=${row['board_num']}">
						${row['board_title']}
					</a>
				</td>
				<td>${row['board_name']}</td>
				<td>
					<f:formatDate value="${row['board_date']}" pattern="yyyy-MM-dd hh:mm:ss"/>
				</td>
				<td>${row['board_readcount']}</td>
			</tr>
		</c:forEach>
	</table>
	<!--[이전][1][2][3][4][5][다음] -->
	<c:if test="${pm.prev}">
		<a href="board_list.jsp?page=member&selectPage=${pm.startPage-1}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${pm.startPage}" end="${pm.endPage}">
		<a href="board_list.jsp?page=member&selectPage=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${pm.next}">
		<a href="board_list.jsp?page=member&selectPage=${pm.endPage + 1}">[다음]</a>
	</c:if>
	
</body>
</html>