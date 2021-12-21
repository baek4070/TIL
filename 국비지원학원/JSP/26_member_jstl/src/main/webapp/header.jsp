<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>
<c:if test="${!empty cookie.u_id and empty sessionScope.member}">
	MyCookie : 쿠키 name : ${cookie.u_id} <br/>
	MyCookie : 쿠키 name : ${cookie.u_id.name} <br/>
	MyCookie : 쿠키 value : ${cookie.u_id.value} <br/>
	MyCookie : 쿠키 value : ${cookie['u_id']['value']} <br/>
	
	<s:query var="rs" dataSource="jdbc/MySqlDB">
		SELECT * FROM smart_member WHERE u_id = ?
		<s:param>${cookie.u_id.value}</s:param>
	</s:query>
	<c:forEach var="data" items="${rs.rows}">
		<jsp:useBean id="member" scope="session" class="vo.MemberVO"/>
		<jsp:setProperty property="u_id" name="member" value="${data['u_id']}"/>
		<jsp:setProperty property="u_num" name="member" value="${data['u_num']}"/>
		<jsp:setProperty property="u_age" name="member" value="${data['u_age']}"/>
		<jsp:setProperty property="u_gender" name="member" value="${data['u_gender']}"/>
		<jsp:setProperty property="u_regdate" name="member" value="${data['u_regdate']}"/>
	</c:forEach>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Member</title>
<link href="css/header.css" rel="stylesheet" type="text/css" />
<link href="css/footer.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header>
		<div>
			<ul>
				<li><a href="main.jsp">home</a></li>
				<c:choose>
					<c:when test="${!empty sessionScope.member}">
						<li><a href="main.jsp?page=info">${member.u_id}</a>님 방가</li>
						<c:if test="${member.u_id eq 'admin'}">
							<li><a href="main.jsp?page=member">회원관리</a></li>
						</c:if>
						<li><a href="logOut.jsp">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="main.jsp?page=login">로그인</a></li>
						<li><a href="main.jsp?page=join">회원가입</a></li>
					</c:otherwise>
				</c:choose>
				
			</ul>
		</div>
		<div>
			<ul>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">질문과답변</a></li>
			</ul>
		</div>
	</header>