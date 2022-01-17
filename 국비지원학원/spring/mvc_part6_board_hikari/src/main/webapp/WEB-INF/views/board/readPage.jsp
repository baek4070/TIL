<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>readPage.jsp</title>
</head>
<body>
	<h3>READ BOARD PAGE</h3>
	<form action="POST">
		<div>
			<label>Title</label>
			<input type="text" name="title"
				   required value="" readonly/>
		</div>
		<div>
			<label>Writer</label>
			<input type="text" name="writer"
				   required value="" readonly/>
		</div>
		<div>
			<label>Content</label>
			<textarea name="content"
				   required readonly rows=5></textarea>
		</div>
		<div>
			<input type="button" value="MODIFY" />
			<input type="button" value="DELETE" />
			<input type="button" value="LIST" />
		</div>
	</form>
</body>
</html>








