<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!-- memberSubmit.jsp -->
<f:requestEncoding value = "utf-8" />
<!-- 게시글 수정 처리 -->
<s:query var="r" dataSource="jdbc/MySqlDB">
	SELECT * FROM test_board 
	WHERE board_num = ? AND board_pass = ?
	<s:param>${param.board_num}</s:param>
	<s:param>${param.board_pass}</s:param>
</s:query>
<c:choose>
	<c:when test="${empty r.rows}">
		<script>
			alert('수정실패! 정보가 일치하지 않습니다.');
			history.go(-1);
		</script>
	</c:when>
	<c:otherwise>
		<s:update dataSource="jdbc/MySqlDB">
			UPDATE test_board SET board_content = ? ,
			board_name = ? , board_title = ? , board_date = now() 
			WHERE board_num = ?
			<s:param>${param.board_content}</s:param>
			<s:param>${param.board_name}</s:param>
			<s:param>${param.board_title}</s:param>
			<s:param>${param.board_num}</s:param>
		</s:update>
<!-- 게시글 수정 결과 처리 -->
		<script>
			location.href="board_detail.jsp?board_num=${param.board_num}";
		</script>
	</c:otherwise>
</c:choose>












