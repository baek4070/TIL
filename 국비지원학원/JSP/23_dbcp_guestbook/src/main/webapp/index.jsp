<%@page import="javax.naming.*"%>
<%@page import="javax.sql.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Context init = new InitialContext();
	    	DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MySqlDB"); //오브젝트 타입 반환이기때문에 타입변환
	    	Connection conn = ds.getConnection();
	    	
	    	String contextPath = request.getContextPath(); //상대경로보단 절대경로를 이용하는게 안전하다
	    	response.sendRedirect(contextPath+"/guestbook/guestbook_list.jsp");
	    	out.print("DB 연결 성공");
    	}catch(Exception e){
	    	out.print("DB 연결 실패");
    	}
    %>
    
    <%-- <jsp:forward page="guestbook/guestbook_list.jsp" /> --%>
