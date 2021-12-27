<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<!-- 게시글 삭제 요청 처리 -->
<f:requestEncoding value="utf-8" />
<s:update dataSource="jdbc/MySqlDB" var="result">
	DELETE FROM test_board 
	WHERE board_num = ${param.board_num} 
	AND board_pass = ?
	<s:param>${param.board_pass}</s:param>
</s:update>
<!-- 게시글 삭제 요청 결과 처리 -->
<c:choose>
	<c:when test="${result > 0}">
		<script>
			alert("삭제 완료");
			location.href="board_list.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("삭제 실패");
			history.back();
		</script>
	</c:otherwise>
</c:choose>
    
    
    
    
    
    
    
    
    
    
    