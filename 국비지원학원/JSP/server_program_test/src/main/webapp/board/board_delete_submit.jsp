<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!-- 게시글 삭제 요청 처리 -->
<f:requestEncoding value="utf-8" />
<c:choose>
<c:when test="${empty param.board_num or empty param.board_pass}">
		<script>
			history.go(-1);
		</script>
	</c:when>
	<c:otherwise>
		<s:update var="result" dataSource="jdbc/MySqlDB">
			DELETE FROM test_board WHERE board_num = ? AND board_pass = ? 
			<s:param>${param.board_num}</s:param>
			<s:param>${param.board_pass}</s:param>
		</s:update>
	</c:otherwise>
</c:choose>
<!-- 게시글 삭제 요청 결과 처리 -->
<c:choose>
	<c:when test="${!empty result and result > 0}">
		<script>
			location.href="board_list.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			history.go(-1);
		</script>
	</c:otherwise>
</c:choose>

