<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyPage.jsp</title>
</head>
<body>
	<h3>MODIFY BOARD PAGE</h3>
	<form action="POST">
		<div>
			<label>Title</label>
			<input type="text" name="title"
				   required value="" />
		</div>
		<div>
			<label>Writer</label>
			<input type="text" name="writer"
				   required value="" />
		</div>
		<div>
			<label>Content</label>
			<textarea name="content"
				   required rows=5></textarea>
		</div>
		<div>
			<input type="submit" value="MODIFY" />
			<input type="button" value="LIST" />
		</div>
	</form>
</body>
</html>








