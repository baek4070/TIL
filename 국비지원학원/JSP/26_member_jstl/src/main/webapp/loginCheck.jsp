<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!-- loginCheck.jsp -->
<f:requestEncoding value="utf-8"/>
<jsp:useBean id="loginMember" class="dto.LoginDTO"/>
<jsp:setProperty property="*" name="loginMember" />

<s:query var="rs" dataSource="jdbc/MySqlDB">
	SELECT * FROM smart_member 
	WHERE u_join = 'Y' AND u_id = ? AND u_pass = ? 
	<s:param>${loginMember.u_id}</s:param>
	<s:param>${loginMember.u_pass}</s:param>
</s:query>
<c:forEach var="d" items="${rs.rows}">
	<jsp:useBean id="member" class="vo.MemberVO" scope="session"/>
	<jsp:setProperty property="u_num" name="member" value="${d.u_num}" />
	<jsp:setProperty property="u_id" name="member" value="${d.u_id}" />
	<jsp:setProperty property="u_age" name="member" value="${d.u_age}" />
	<jsp:setProperty property="u_gender" name="member" value="${d.u_gender}" />
	<jsp:setProperty property="u_regdate" name="member" value="${d.u_regdate}" />
</c:forEach>
<!-- 로그인 성공 -->
<c:choose>
	<c:when test="${!empty member}">
		<!-- 자동 로그인 처리- Cookie -->
		<c:if test="${!empty loginMember.login}">
			<%
				Cookie cookie = new Cookie("u_id",loginMember.getU_id());
				cookie.setMaxAge(60*60*24*7);
				cookie.setPath("/");
				response.addCookie(cookie);
			%>
		</c:if>
		<script>
			alert('${member.u_id} : 로그인 성공');
			location.href='main.jsp';
		</script>
	</c:when>
	<c:otherwise>
		<!-- 로그인 실패 -->
		<script>
			alert('로그인 실패');
			history.go(-1);
		</script>
	</c:otherwise>
</c:choose>