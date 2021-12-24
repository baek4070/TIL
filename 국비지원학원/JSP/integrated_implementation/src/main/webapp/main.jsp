<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="pageSelect" value="${param.page}.jsp"/>

<c:if test="${pageSelect eq '.jsp'}">
	<c:set var="pageSelect" value="default.jsp"/>
</c:if>

<c:set var="pageSelect" value="${pageSelect}"/>

<jsp:include page="header.jsp" />

<section class="wrap">
	<jsp:include page="${pageSelect}" />
</section>
	
<jsp:include page="footer.jsp"/>