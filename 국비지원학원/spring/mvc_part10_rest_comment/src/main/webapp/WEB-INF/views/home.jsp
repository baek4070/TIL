<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMENT TEST</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h2>AJAX - REST TEST PAGE</h2>
<div>
	<div id="title"></div>
	<div>
		comment auth : <input type="text" id="cAuth" placeholder="작성자 이름 작성" />
	</div>
	<div>
		comment content : <input type="text" id="cText" placeholder="댓글 내용 작성" />
	</div>
	<button id="addBtn">ADD COMMENT</button>
</div>
<div>
	<!-- 댓글 리스트 -->
	<ul id="comments"></ul>
	<!-- 댓글 페이징 처리 -->
	<ul id="pagination"></ul>
</div>
<script>
	// 초기값은 1번 게시물
	var bno = 1;
	// 초기값은 첫번째 페이지
	var page = 1;
	
	getCommentList();
	
	// bno 게시물의 전체 댓글 목록
	function getCommentList(){
		// type : GET , dataType : "json"
		//$.getJSON(url,callback함수);
		var url = "comments/all/"+bno;
		$.getJSON(url,function(data){
			console.log(data);
		});
	}

</script>
</body>
</html>








