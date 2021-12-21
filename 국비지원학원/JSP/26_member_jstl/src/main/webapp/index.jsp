<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%-- <% response.sendRedirect("main.jsp?page=default"); %> --%>
<c:redirect url="main.jsp">
	<c:param name="page" value="default"/>
</c:redirect>

<script>
	//location.href='main.jsp';
</script>