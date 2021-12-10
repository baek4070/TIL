<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nextPage = request.getParameter("page");
	if(nextPage == null){
		nextPage = "default";
	}
	// default - intro - map 
	nextPage = nextPage + ".jsp";
	System.out.println("nextPage : "+ nextPage);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		position : static;
		margin: 0 auto;
		width : 900px;
		height : 700px;
	}
	header {
		position: static;	
		height : 100px;
		overflow: hidden
	}
	#table {
		margin: 55px 0 0 700px;
	}
	th{
		font-size: x-large;
	}
	#jointb, #logintb{
		text-align : center;
		border-spacing:15px;
		margin: 0 auto;
	}
	section {
		position:static;
		height : 500px;
		display: flex;
  		align-items: center;
        justify-content: center;
	}
	footer {
		height : 100px;
	}
</style>
</head>
<body>
	<header>
		<jsp:include page="header.jsp"/>
	</header>
	<section>
		<jsp:include page="<%=nextPage%>"/>
	</section>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
</body>
</html>