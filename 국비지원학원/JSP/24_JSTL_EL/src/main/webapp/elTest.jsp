<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>

session :<%=session.getAttribute("test")%><br/>
EL scope session : ${sessionScope.test}<br/>
EL ${test}<br/>

parameter : <%=request.getParameter("aaa") %><br/>
EL param : ${param.aaa}<br/>

<input type="text" value="${param.aaa}"/>
</body>
</html>