<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bean Test</h1>
	<%
		test.Member m = null;
		if(pageContext.findAttribute("m") == null){
			m = new test.Member();
			System.out.println(m.getName());
			m.setName("쉬면석");
			pageContext.setAttribute("m",m);
		}else{
			m = (test.Member)pageContext.findAttribute("m");
		}
	%>

	<%=((test.Member)pageContext.getAttribute("m")).getName() %>
	<!-- 이런노가다 말고 이제 유즈빈을 써보자 -->
	<jsp:useBean id="aaa" class="test.Member" scope="page" />
	<jsp:useBean id="bbb" class="test.Member" scope="request" />
	<jsp:useBean id="ccc" class="test.Member" scope="session" />
	<jsp:useBean id="ddd" class="test.Member" scope="application" />
	<!-- 일단 들어가있는것임 ; 확인해보자 -->
	<br/>
	<%aaa.setName("쉬면석"); %>
	<jsp:setProperty property="name" name="aaa" value="김유신"/>
	<%="aaa name : "+aaa.getName()%>
	<br/>
	aaa name : <jsp:getProperty property="name" name="aaa" /> 
</body>
</html>