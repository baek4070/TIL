<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:requestEncoding value="utf-8" />
<c:catch var="e">
<jsp:useBean id="article" class="vo.TestBoardVO"/>
<jsp:setProperty property="*" name="article"/>
</c:catch>
<c:choose>
	<c:when test="${!empty e}">
		<script>
			alert('입력이 잘못되었습니다');
			history.go(-1);
		</script>
	</c:when>
	<c:otherwise>
		<!-- 게시글 작성 요청 처리 -->
		<s:update dataSource="jdbc/MySqlDB">
			INSERT INTO test_board(board_name,board_pass,board_title,board_content) 
			VALUES(?,?,?,?)
			<s:param>${article.board_name}</s:param>
			<s:param>${article.board_pass}</s:param>
			<s:param>${article.board_title}</s:param>
			<s:param>${article.board_content}</s:param>
		</s:update>
		<!-- 게시글 작성 결과 처리 -->
		<script>
			location.href="board_list.jsp";
		</script>
	</c:otherwise>
</c:choose>















