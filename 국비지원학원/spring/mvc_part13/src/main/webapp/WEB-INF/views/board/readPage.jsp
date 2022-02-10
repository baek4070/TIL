<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/readPage.jsp</title>
</head>
<body>
	<h1><a href="${pageContext.request.contextPath}">HOME</a></h1>
	<h3>READ PAGE</h3>
	<table border=1>
		<tr>
			<td>제목</td>
			<td>${board.title}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.content}</td>
		</tr>
	</table>
	<hr/>
	<div>
		<c:if test="${!empty userInfo}">
			<c:if test="${userInfo.uno eq board.uno}">
				<input type="button" id="modifyBtn" value="MODIFY"/>
				<input type="button" id="deleteBtn" value="DELETE"/>
			</c:if>
			<input type="button" id="replyBtn" value="REPLY"/>
		</c:if>
		<input type="button" id="listBtn" value="LIST"/>
	</div>
	
	<form id="readForm">
		<input type="hidden" name="csrf_token" value="${csrf_token}"/>
		<input type="hidden" name="bno" value="${board.bno}"/>
		<input type="hidden" name="page" value="${cri.page}"/>
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}"/>
		<input type="hidden" name="searchType" value="${cri.searchType}"/>
		<input type="hidden" name="keyword" value="${cri.keyword}"/>
	</form>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	var formObj = $("#readForm");
	// 게시글 목록
	$("#listBtn").click(function(){
		formObj.attr("action","listReply").submit();
	});
	// 답변글 작성
	$("#replyBtn").click(function(){
		formObj.attr("action","replyRegister").submit();
	});
	
	// 게시글 수정
	$("#modifyBtn").click(function(){
		formObj.attr("action","modifyPage").submit();
	});
	
	// 삭제 요청
	$("#deleteBtn").click(function(){
		var isDelete = confirm("게시글을 삭제하시겠습니까?");
		if(isDelete){
			formObj.attr("action","remove");
			formObj.attr("method","post");
			formObj.submit();
		}else{
			alert("삭제 요청이 취소되었습니다.");
		}
	});
	
</script>
</body>
</html>















