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
	
	/* ¥Ò±€ ∏ÆΩ∫∆Æ */
	.commentListWrap{
		width:100%;
		border:1px solid #ddd;
		padding:15px;
		margin-top:15px;
	}
	
	.commentListWrap textarea{
		border:none;
		resize:none;
		outline:0;
		font-size:1.3em;
		color:#333;
		width:100%;
	}
	
	.closeBtn{
		float:right;
		border:1px solid #ccc;
		padding:2px;
	}
	
	.closeBtn input{
		border:none;
		outline:none;
		background:none;
		color:red;
	}
	
	.closeBtn:hover input{
		cursor:pointer;
	}
	
	/* ∆‰¿Ã¬° ∫Ì∑∞ */
	.pagingWrap{
		width:100%;
		text-align:center;
		margin-top:15px;
		margin-bottom:50px;
	}
	
	a{
		text-decoration:none;
		color:black;
	}
	
	a:hover{
		color:#ccc;
	}
	
	
</style>
<c:if test="${!empty member}">
	<div class="commentWrap">
		<h3>¥Ò±€¿€º∫</h3>	
		<br/>
		<div class="commentWrite">
			<form action="commentWrite.bo" method="POST">
				<input type="hidden" name="id" value="${member.id}"/>
				<input type="hidden" name="name" value="${member.name}"/>
				<input type="hidden" name="qna_num" value="${boardVO.qna_num}"/>
				<textarea name="comment_content" class="comment_content" required></textarea>
				<input type="submit" value="µÓ∑œ"/>
			</form>
		</div>
	</div>
</c:if>
<!-- hm(map) -->
<!-- ∞‘Ω√±€ ªÛºº : boardVO -->
<!--  ¥Ò±€ ∏ÆΩ∫∆Æ : hm.list -->
<!--  ¥Ò±€ ∆‰¿Ã¬° : hm.pm -->
<c:if test="${!empty hm.list}">
	<br/>
	<h3>¥Ò±€ ∏Ò∑œ[${hm.pm.totalCount}]</h3>
	<c:forEach var="cmt" items="${hm.list}">
		<div class="commentListWrap">
				<c:choose>
			<c:when test="${cmt.comment_delete eq 'N'}">
				<c:if test="${!empty member && member.id eq cmt.comment_id}">
					<form action="commentDelete.bo" method="POST">
						<input type="hidden" name="id" value="${member.id}" />
						<input type="hidden" name="comment_num" value="${cmt.comment_num}" />
						<input type="hidden" name="qna_num" value="${boardVO.qna_num}" />
						<div class="closeBtn">
							<input type="submit" value="X" title="¥Ò±€ ªË¡¶"/>
						</div>
					</form>
				</c:if>
				<div>
					${cmt.comment_name}&nbsp;&nbsp;|&nbsp;&nbsp;${cmt.comment_date}
				</div>
				<div>
					<textarea readonly>${cmt.comment_content}</textarea>
				</div>
			</c:when>
			<c:otherwise>
				<h3>ªË¡¶µ» ¥Ò±€¿‘¥œ¥Ÿ.</h3>
			</c:otherwise>
			</c:choose>
		</div>
	</c:forEach>
	<div class="pagingWrap">
		<c:forEach var="i" begin="${hm.pm.startPage}" 
		end="${hm.pm.endPage}">
			<a href="boardRead.bo?page=${i}&qna_num=${boardVO.qna_num}">[${i}]</a>
		</c:forEach>	
	</div>
	
	
</c:if>