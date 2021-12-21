<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!-- joinCheck.jsp -->
<f:requestEncoding value="utf-8" />
<c:catch var="e">
	<jsp:useBean id="joinMember" class="vo.MemberVO"/>
	<jsp:setProperty property="*" name="joinMember"/>
</c:catch>

<s:query var="rs" dataSource="jdbc/MySqlDB">
	SELECT * FROM smart_member WHERE u_id = ? 
	<s:param>${joinMember.u_id}</s:param>
</s:query>
<c:choose>
	<c:when test="${!empty e}">
		<script>
			alert('회원정보가 잘못되었습니다.');
			history.go(-1);
		</script>
	</c:when>
	<c:when test="${!empty rs.rows}">
		<script>
			alert('이미 사용중인 아이디 입니다.');
			history.go(-1);
		</script>
	</c:when>
	<c:otherwise>
		<!-- 회원가입 처리 -->
		<s:update dataSource="jdbc/MySqlDB">
			INSERT INTO smart_member(u_id,u_pass,u_age,u_gender) 
			VALUES(?,?,?,?)
			<s:param>${joinMember.u_id}</s:param>
			<s:param>${joinMember.u_pass}</s:param>
			<s:param>${joinMember.u_age}</s:param>
			<s:param>${joinMember.u_gender}</s:param>
		</s:update>
		<script>
			alert('회원가입 성공');
			location.href="main.jsp?page=login";
		</script>
	</c:otherwise>
</c:choose>











