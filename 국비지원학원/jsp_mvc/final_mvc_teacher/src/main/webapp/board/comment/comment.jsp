<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- common/comment.jsp -->
<style>
	.commentWrap{
		width:100%;
		border:1px solid #ddd;
		padding:15px;
		margin-top:15px;
		margin-bottom:10px;
	}
	
	.commentWrap .commentWrite textarea.comment_content{
		border:none;
		resize:none;
		outline:0;
		font-size:1.1em;
		color:#333;
		float:left;
		height:70px;
		padding:5px;
		width:85%;
	}
	
	.commentWrap .commentWrite{
		border:1px solid #ccc;
		overflow:hidden;
	}
	
	.commentWrite input[type='submit']{
		float:right;
		width:13%;
		height:80px;
		font-weight:bold;
	}
	
</style>
<c:if test="${!empty member}">
	<div class="commentWrap">
		<h3>댓글작성</h3>	
		<br/>
		<div class="commentWrite">
			<form action="#" method="POST">
				<input type="hidden" name="id" value="${member.id}"/>
				<input type="hidden" name="name" value="${member.name}"/>
				<input type="hidden" name="qna_num" value="${boardVO.qna_num}"/>
				<textarea name="comment_content" class="comment_content" required></textarea>
				<input type="submit" value="등록"/>
			</form>
		</div>
	</div>
</c:if>