<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!-- page session true로 설정 !  -->
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
${sessionScope.member} <br/>
<a href="write">write</a>
<!-- 바로 save 하려하면 character encoding 오류상자 뜨는거 확인 -->
</body>
</html>
