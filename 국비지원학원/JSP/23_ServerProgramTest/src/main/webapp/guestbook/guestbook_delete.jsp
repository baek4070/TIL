<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ include file="../connection.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>방명록 메시지 삭제함</title>
</head>
<body>
<br/>

<!-- 삭제 확인 처리  알림 code 작성-->
<%
	request.setCharacterEncoding("utf-8");
	String num = request.getParameter("id");
	String password = request.getParameter("password");
	
	PreparedStatement pstmt = null;
	String msg = null;
	try{
		String sql = "DELETE FROM test_guestbook WHERE id = ? AND password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(num));
		pstmt.setString(2,password);
		int result = pstmt.executeUpdate();
		msg = (result > 0) ? "방명록을 삭제하였습니다" : "방명록 삭제 실패 하였습니다" ;
	}catch(Exception e){
		msg = "삭제 시 문제가 발생했습니다.";
	}finally{
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
%>
<h2><%=msg%></h2>
<a href="../index.jsp">[목록 보기]</a>
</body>
</html>