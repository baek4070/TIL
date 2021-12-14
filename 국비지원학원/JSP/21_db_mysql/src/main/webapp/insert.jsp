<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC CONNECTION INSERT TEST</title>
</head>
<body>
<!--연결객체 api 임폴트 ~ 해주어야한다   -->
<%@ page import = "java.sql.*" %> 
<%
	request.setCharacterEncoding("UTF-8"); //post로 넘어오는거니까 인코딩 설정먼저
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	
	Connection conn = null;
	Statement stmt = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/smartWeb";
	String user = "smart";
	String pass = "12345";
	
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url,user,pass);
		out.print("<h3>database 연결 성공</h3>");
		stmt = conn.createStatement();
		String sql = "INSERT INTO member(name,addr)"+" VALUES('"+name+"','"+addr+"')";
		System.out.println("sql : " + sql);
		int result = stmt.executeUpdate(sql);
		if(result > 0){
			out.print("회원정보 등록완료");
		}else{
			out.print("회원정보 등록실패");
		}
		
	}catch(Exception e){
		out.print("<h3>database 연결 실패</h3>");
		out.print("<h2>"+e.toString()+"</h2>");
	}finally{
		stmt.close();
		conn.close();
	}
%>
<br/>
<a href="index.jsp">메인으로</a>
</body>
</html>