<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<%@ page import = "util.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>방명록 메시지 삭제함</title>
</head>
<body>
<br/>
<%
	request.setCharacterEncoding("utf-8");
	String msg = "";
	String paramID = request.getParameter("id");
	String password = request.getParameter("password");
	
	Connection conn = DBCPUtil.getConnection();
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = "";
	// ' OR 1=1 -- sql 인젝션
	try{
		int id = Integer.parseInt(paramID);
		/*
		sql = "DELETE FROM test_guestbook"+" WHERE id="+id+" AND password='"+password+"'";
		stmt = conn.createStatement();
		*/
		sql ="DELETE FROM test_guestbook"+" WHERE id = ? AND password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		pstmt.setString(2,password);
		msg = (pstmt.executeUpdate() > 0)
				? "삭제 성공" : "삭제 실패";
	}catch(Exception e){
		msg = "삭제 실패";
	}finally{
		DBCPUtil.close(pstmt,stmt,conn);
	}
%>

<!-- 삭제 확인 처리  알림 code 작성-->
<h3><%=msg%></h3>
<a href="guestbook_list.jsp">[목록 보기]</a>
</body>
</html>