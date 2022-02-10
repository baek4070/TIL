<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.fileDrop{
		width:100%;
		height:150px;
		border:1px solid gray;
		background-color:lightgray;
		margin:auto;
	}
</style>
</head>
<body>
	<h1>
		<a href="${pageContext.request.contextPath}">HOME</a>
	</h1>
	<h3>REGISTER BOARD</h3>
	<form id="registerForm" action="register" method="POST">
		<input type="hidden" name="uno" value="${userInfo.uno}"/>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" required /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${sessionScope.userInfo.uname}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" rows="30" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="saveBtn" value="등록" />
				</td>
			</tr>
		</table>
		<div>
			<label>FILE DROP HERE</label>
			<div class="fileDrop">
			
			</div>		
		</div>
		<div>
			<ul class="uploadList">
				
			</ul>
		</div>
	</form>
<script src="http://code.jquery.com/jquery-latest.min.js" ></script>
<script>
	var contextPath = '${pageContext.request.contextPath}';

	$(".fileDrop").on("dragenter dragover", function(e){
		e.preventDefault();
	});

	$(".fileDrop").on("drop", function(e){
		e.preventDefault();
		var files = e.originalEvent.dataTransfer.files;
		console.log(files);
		
		// 1024(1kb) * 1024(1kb) = 1048576(1MB) *10 = 10MB
		var maxSize = 10485760;
		
		var formData = new FormData();
		
		for(var i=0; i < files.length; i++ ){
			if(files[i].size > maxSize){
				alert("업로드 할 수 없는 크기의 파일이 포함되어 있습니다.");
				return;
			}
			formData.append("file", files[i]);
		}
		
		$.ajax({
			type : "POST",
			url : contextPath+'/uploadFile',
			data : formData,
			dataType : "json",
			processData : false,
			contentType : false,
			success : function(result){
				console.log(result);
			},
			error : function(res){
				alert(res.responseText);
			}
		});
		
		
	});

	$("#saveBtn").click(function(){
		$("#registerForm").submit();
	});
</script>
</body>
</html>
























