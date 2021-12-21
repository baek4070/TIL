<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!-- withdraw.jsp -->
<c:choose>
	<c:when test="${empty member ||
			member.u_id ne param.u_id
			|| 
			member.u_id eq 'admin'}">
		<script>
			alert("잘못된 요청입니다.");
			history.back();
		</script>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>










