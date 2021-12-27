<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<s:query var="result" dataSource="jdbc/MySqlDB">
	SELECT * FROM test_board ORDER BY board_num DESC
</s:query>
<c:set var="page" value="1"/>
<c:if test="${!empty param.page}">
	<c:set var="page" value="${param.page}"/>
</c:if>
<jsp:useBean id="cri" class="util.Criteria"/>
<jsp:setProperty name="cri" property="page" value="${page}"/>
<jsp:setProperty name="cri" property="perPageNum" value="20"/>

<jsp:useBean id="pageMaker" class="util.PageMaker" />
<jsp:setProperty name="pageMaker" property="cri" value="${cri}"/>
<jsp:setProperty name="pageMaker" property="displayPageNum" value="5"/>
<jsp:setProperty name="pageMaker" property="totalCount" value="${result.rowCount}"/>

<s:query var="rs" dataSource="jdbc/MySqlDB" 
startRow="${cri.startRow}" maxRows="${cri.perPageNum}">
SELECT * FROM test_board 
ORDER BY board_num DESC
</s:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageContext.request.contextPath}</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<a href="${path}/board/board_write.jsp">게시글 작성하러 가기</a>
	<table border=1>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
		</tr>
		<!-- 게시글 목록 -->
		<c:choose>
			<c:when test="${rs.rowCount > 0}">
				<c:forEach var="b" items="${rs.rows}">
					<tr>
						<td>${b.board_num}</td>
						<td>
							<a href="${path}/board/board_detail.jsp?board_num=${b.board_num}">
							${b.board_title}
							</a>
						</td>
						<td>${b.board_name}</td>
						<td>${b.board_date}</td>
						<td>${b.board_readcount}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">등록된 정보가 없습니다.</td>
				</tr>
			</c:otherwise>		
		</c:choose>
	</table>
	<!-- 페이지 블럭 작성  -->
	<hr/>
	<c:if test="${cri.page > 1}">
		<a href="${path}/board/board_list.jsp?page=1">[처음]</a>
		<c:if test="${pageMaker.prev}">
			<a href="${path}/board/board_list.jsp?page=${startPage-1}">[이전]</a>
		</c:if>
	</c:if>
	<c:forEach var="i" begin="${pageMaker.startPage}" 
					   end="${pageMaker.endPage}" step="1">
		<a href="${path}/board/board_list.jsp?page=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${cri.page < pageMaker.maxPage}">
		<c:if test="${pageMaker.next}">
			<a href="${path}/board/board_list.jsp?page=${pageMaker.endPage+1}">[다음]</a>
		</c:if>
		<a href="${path}/board/board_list.jsp?page=${pageMaker.maxPage}">[마지막]</a>
	</c:if>
	<hr/>
	${pageMaker}
	<hr/> 
</body>
</html>










