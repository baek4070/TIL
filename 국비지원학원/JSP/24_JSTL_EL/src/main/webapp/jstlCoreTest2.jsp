<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlCoreTest2.jsp</title>
</head>
<body>
	<h1>제어문</h1>
	<c:set var="myCar" value="빨강"/>
	
	<c:if test="${myCar eq'파랑'}">
		색상 파랑색!!<br/>
	</c:if>
	<c:if test="${myCar ne'파랑'}">
		색상 빨강색!!!!<br/>
	</c:if>
	<c:set var="grade" value="30"/>
	<c:choose>
		<c:when test="${grade >= 90}">
			A학점
		</c:when>
		<c:when test="${grade >= 80}">
			b학점
		</c:when>
		<c:when test="${grade >= 70}">
			C학점
		</c:when>
		<c:otherwise>
			F학점
		</c:otherwise>
	</c:choose>
	
	<%
		int[] num = {10,9,8,7,6,5,4,3,2,1};
		request.setAttribute("numArray", num);
	%>
	<br/>
	<c:forEach var="n" items="${numArray}">
		${n} &nbsp;&nbsp;
	</c:forEach>
	<br/>
	${n}
	<br/>
	<c:forEach var="i" begin="1" end="100" step="1">
		${i} &nbsp;
	</c:forEach>
	<br/>
	<c:set var="data" value="문다영,심현석,김재관,이광호,김회진"/>
	<!-- 특정 문자열에서 구분자를 이용하여 문자를 잘라내서 변수에 값을 저장, 스플릿과 반복문이 합쳐진느낌쓰 -->
	<c:forTokens var="name" items="${data}" delims=",">
		${name} &nbsp;&nbsp;
	</c:forTokens>
	<%
		java.util.ArrayList<String> list = new java.util.ArrayList<>();
		list.add("리트리버");
		list.add("시베리안 허스키");
		list.add("진돗개");
		list.add("푸들");
		list.add("비글");
		list.add("치와와");
		request.setAttribute("dogList", list);
	%>
	<br/>
	<c:choose>
		<c:when test="${!empty dogList}">
			<c:forEach var="dog" items="${dogList}">
				${dog} &nbsp;
			</c:forEach>
		</c:when>
		<c:otherwise>
			목록이 존재하지 않습니다.
		</c:otherwise>
	</c:choose>
</body>
</html>