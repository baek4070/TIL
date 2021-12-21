<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!-- memberDelete.jsp -->
<%--${param.u_num}--%>
<s:update dataSource="jdbc/MySqlDB">
	UPDATE smart_member SET u_join = 'N',
	u_regdate = now()
	WHERE u_num = ?
	<s:param>${param.u_num}</s:param>
</s:update>
<script>
	alert("삭제완료");
	location.href="main.jsp?page=member";
</script>