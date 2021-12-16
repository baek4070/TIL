<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String num = request.getParameter("board_num");
	if(num == null || num.trim().equals("")){
		out.print("<script>alert('잘못된 접근입니다.');history.go(-1);</script>");		
		return;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String title = null;
	String auth = null;
	String content = null;
	int board_num = 0;
	
	try{
		Context init = new InitialContext();
		DataSource ds 
		= (DataSource)init.lookup("java:comp/env/java/MySqlDB");
		conn = ds.getConnection();
		board_num = Integer.parseInt(num);
		// 192.168.1.96 - 심현석
		String sql = "SELECT * FROM board_test WHERE board_num = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, board_num);
		rs = pstmt.executeQuery();
		if(rs.next()){
			title = rs.getString("board_title");
			auth = rs.getString("board_auth");
			content = rs.getString("board_content");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>
	<form action="updateSubmit.jsp" method="POST">
		<input type="hidden" name="board_num" value="<%=num%>"/>
		<table>
			<tr>
				<th colspan="2">
					<h2>게시글 수정</h2>
				</th>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="board_title" value="<%=title%>" autofocus required />
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="board_auth" value="<%=auth%>" required /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="board_content" style="resize:none;" rows="20" cols="50"><%=content%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="작성완료"/> 
					<input type="reset" value="다시쓰기"/>
					<input type="button" onclick="location.href='index.jsp';" value="메인으로"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>










