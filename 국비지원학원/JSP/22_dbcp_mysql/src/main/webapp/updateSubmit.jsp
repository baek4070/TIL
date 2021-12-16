<%@page import="java.sql.CallableStatement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- updateSubmit.jsp -->
<%
	request.setCharacterEncoding("UTF-8");
	String num = request.getParameter("board_num");
	String title = request.getParameter("board_title");
	String auth = request.getParameter("board_auth");
	String content = request.getParameter("board_content");
	int board_num = Integer.parseInt(num);
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	CallableStatement c;
	String msg = "";
	
	try{
		Context init = new InitialContext();
		DataSource ds 
		= (DataSource)init.lookup("java:comp/env/java/MySqlDB");
		conn = ds.getConnection();
		String sql = "UPDATE board_test SET " 
				    +" board_title = ? , " 
		    		+" board_auth = ? , "
    				+" board_content = ? " 
 					+" WHERE board_num = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, auth);
		pstmt.setString(3, content);
		pstmt.setInt(4, board_num);
		pstmt.executeUpdate();
		msg = "수정 완료";
	}catch(Exception e){
		e.printStackTrace();
		msg = "수정 실패";
	}finally{
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		out.print("<script>");
		out.print("alert('"+msg+"');");
		out.print("location.href='index.jsp';");
		out.print("</script>");
	}
%>












