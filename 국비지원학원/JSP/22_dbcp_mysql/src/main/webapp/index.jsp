<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String result = null;

try{
	// tomcat Server 설정 정보
	Context init = new InitialContext();
	// JNDI(Java Naming and Dirctory Interface)
	// 디렉토리 서비스에서 제공하는 
	// 데이터및 객체를 발견하고 참고 하기위한 API
	// java:comp/env/ 공식 접두어
	DataSource ds = 
		(DataSource)init.lookup("java:comp/env/java/MySqlDB");
	conn = ds.getConnection();
	out.println("데이터 베이스 연결 성공");
	
	String sql = "SELECT * FROM board_test ORDER BY board_num DESC";
	sql = "SELECT ROW_NUMBER() OVER(ORDER BY board_num ASC) AS rnum, "
		+ " board_test.* FROM board_test ORDER BY rnum DESC";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
}catch(Exception e){
	out.println("데이터 베이스 연결 실패");
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
		<br/>
		<a href="writeForm.jsp">글작성</a> 
		<a href="boardList.jsp">페이징 처리된 게시판</a>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
				<th>기타</th>
			</tr>
			<%
				while(rs.next()){
			%>
				<tr>
					<td><%=rs.getInt("rnum")%></td>
					<td><%=rs.getString("board_title")%></td>
					<td><%=rs.getString("board_auth")%></td>
					<td><%=rs.getTimestamp("board_date")%></td>
					<td>
						<a href="updateForm.jsp?board_num=<%=rs.getInt("board_num")%>">수정</a> | 
						<a href="delete.jsp?board_num=<%=rs.getInt("board_num")%>">삭제</a>
					</td>
				</tr>
			<%
				}
			%>
		</table>
	</section>
	<%
		rs.close();
		pstmt.close();
		conn.close();
	%>

</body>
</html>







