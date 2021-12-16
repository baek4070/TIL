<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- delete.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	String num = request.getParameter("board_num");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String msg = null;
	
	try{
		Context init = new InitialContext();
		DataSource ds = 
		(DataSource)init.lookup("java:comp/env/java/MySqlDB");
		conn = ds.getConnection();
		String sql = "DELETE FROM board_test WHERE board_num = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(num));
		int result = pstmt.executeUpdate();
		msg = (result > 0) ? "삭제완료" : "삭제 내용이 없습니다." ;
	}catch(Exception e){
		msg = "삭제 시 문제가 발생했습니다.";
	}finally{
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		out.print("<script>");
		out.print("alert('"+msg+"');");
		out.print("location.href='index.jsp';");
		out.print("</script>");
	}
%>














