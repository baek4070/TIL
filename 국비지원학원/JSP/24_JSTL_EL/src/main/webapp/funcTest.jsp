<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>funcTest.jsp</title>
</head>
<body>
	<c:set var="test" value="Hello, Java Server Pages!"/>
	toUpperCase : ${fn:toUpperCase(test)}<br/>
	toLowerCase : ${fn:toLowerCase(test)}<br/>
	
	<c:set var="text" value="image.png"/>
	startsWith : ${fn:startsWith(text,"image")} <br/>
	endsWith : ${fn:endsWith(text,".png")} <br/>
	<hr/>
	contains : ${fn:contains(test,"java")} <br/>
	containsIgnoreCase : ${fn:containsIgnoreCase(test,"java")}<br/>
	<hr/>
	indexOf : ${fn:indexOf(test,"Java")} <br/>
	substringBefore : ${fn:substringBefore(test,"Java")} <br/>
	substringAfter :  ${fn:substringAfter(test,"Java")} <br/>
	<!-- substring(text,startIndex, endIndex(-1)) -->
	substring : ${fn:substring(test,fn:indexOf(test,"Java"),11)} <br/>
	<hr/>
	<c:set var="strs" value="${fn:split(test,' ')}"/>
	<c:forEach var="str" items="${strs}">
		${str} <br/>
	</c:forEach>
	<hr/>
	${fn:join(strs,"|")} <br/>
	<c:set var="err" value="<div style='border:1px solid red;'>안녕하세요</div>"/>
	${err} <br/>
	escapeXml = ${fn:escapeXml(err)} <br/>
	<hr/>
	${fn:replace(err,'<','&rt;')}<br/>
</body>
</html>












