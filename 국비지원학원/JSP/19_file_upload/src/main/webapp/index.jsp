<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<!-- 
	application/x-www-form-urlencoded
	기본값, 모든문자들을 서버로 보내기 전에 인코딩 됨을 명시함.
	multipart/form-data
	모든 문자를 인코딩하지 않음을 명시.
	이 방식은 form 요소에서 파일이나 이미지를 서버에 전송할때 사용됨.
	text/plain
	공백 문자(space)는 +기호로 변환 되지만
	나머지 문자는 인코딩 되지 않음을 명시
 -->
	<h3>single file - cos</h3>
	<form action="upload.cos" method="POST" enctype="multipart/form-data">
		<input type = "file" name = "file" accept="image/*" />
		<input type="text" name="test" />
		<input tepe= "submit" /> 
	</form>
</body>
</html>