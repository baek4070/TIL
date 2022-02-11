<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- comment.jsp -->
<div>
	<!-- 로그인 된 사용자 -->
	<c:if test="${!empty userInfo}">
		<table border=1>
			<tr>
				<th colspan="2">ADD NEW COMMENT</th>
			</tr>
			<tr>
				<td>COMMENT AUTH</td>
				<td>${userInfo.uname}</td>
			</tr>	
			<tr>
				<td>COMMENT TEXT</td>
				<td>
					<input type="text" id="commentText" placeholder="COMMENT TEXT"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="ADD BUTTON" />
				</td>
			</tr>
		</table>
	</c:if>
</div>
<br/><hr/><br/>
<div id="modDiv">
	<h3>댓글 수정 &amp;삭제</h3>
	<!-- 댓글 번호 -->
	<div class="mod-title"></div>
	<!-- 댓글 내용 -->
	<div>
		<input type="text" id="modCommentText" />
	</div>
	<div>
		<input type="button" id="commentModBtn" value="MODIFY"/>
		<input type="button" id="commentDelBtn" value="DELETE"/>
		<input type="button" id="closeBtn" value="CLOSE"/>
	</div>
</div>
<div>
	<ul id="comments">
		
	</ul>
</div>
<script>
	
	var bno = '${board.bno}';
	var commentPage = 1;
	
	getListPage(commentPage);
	
	function getListPage(page){
		// /common/comments/2/1
		$.getJSON('${path}/comments/'+bno+'/'+page, function(data){
			// data == Map<String,Object>
			// data.list = List<CommentVO>
			// data.pm = PageMaker
			console.log(data);
		});
	}

</script>







