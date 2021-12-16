<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
int currentPage = 1; // 요청 들어온 현재 페이지 번호
int pageCount = 10;  // 한번에 보여줄 게시물의 수
int listCount = 0;   // 전체 게시물의 수
int startPage = 0;   // 현재 페이지 블럭에 보여줄 시작 페이지 번호
int endPage = 0;     // 현재 페이지 블럭에 보여줄 마지막 페이지 번호 
int maxPage = 0;     // 전체 페이지 블럭에 보여줄 마지막 페이지 번호
int displayPageNum = 5; // 한번에 보여줄 페이지 블럭 수
int startRow = 0;    // 테이블에서 pageCount만큼 검색할 시작 인덱스
int endRow = 0;      // 테이블에서 검색할 게시물의 개수

request.setCharacterEncoding("UTF-8");
String paramPage = request.getParameter("page");
if(paramPage != null){
	currentPage = Integer.parseInt(paramPage);
}
System.out.println("currentPage : " + currentPage);

startRow = (currentPage - 1) * pageCount;
endRow = pageCount;

// DB 검색
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String result = "";

Context init = new InitialContext();
DataSource ds 
	= (DataSource)init.lookup("java:comp/env/java/MySqlDB");
conn = ds.getConnection();

//페이징 블럭 처리
String sql ="SELECT count(*) FROM board_test";
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery();
if(rs.next()){
	listCount = rs.getInt(1);
}
System.out.println("전체 게시물 수 : " + listCount);
maxPage = (listCount-1) / pageCount + 1;
System.out.println("전체 페이지 블럭 개수 : " + maxPage);
// displayPageNum : 5
// 1 ~ 5  == 1
// 6 ~ 10 == 6 
startPage = (currentPage-1) / displayPageNum * displayPageNum +1;
endPage = startPage +(displayPageNum - 1);

if(endPage > maxPage){
	endPage = maxPage;
}



// 페이징 처리 End

// 게시물 검색
sql = "SELECT * FROM board_test "
			+"ORDER BY board_num DESC limit ? , ?";
pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, startRow);
pstmt.setInt(2, endRow);
rs = pstmt.executeQuery();









%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
<style>
	section{
		text-align:center;
	}
	table{
		border-collapse:collapse;
		border:1px solid black;
		margin:50px auto;
	}
	table th, table td{
		border:1px solid #ccc;
		padding:10px;
	}
</style>
</head>
<body>
	<section>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
				<th>기타</th>
			</tr>
			<%while(rs.next()){ %>
				<tr>
					<td><%=rs.getInt("board_num")%></td>
					<td><%=rs.getString("board_title")%></td>
					<td><%=rs.getString("board_auth")%></td>
					<td><%=rs.getTimestamp("board_date")%></td>
					<td></td>
				</tr>
			<%}%>
		</table>

		<div class="pageWrap">
			<% if(currentPage != 1){%>	
				<a href="boardList.jsp?page=1">[처음]</a>
			<%}%>
			<%if((startPage-1) > 0) {%>
				<a href="boardList.jsp?page=<%=startPage-1%>">[이전]</a>
			<%}%>
			<%for(int i=startPage; i<=endPage;i++){ %>
				<a href="boardList.jsp?page=<%=i%>">[<%=i%>]</a>
			<%}%>
			<%if(endPage < maxPage){%>
				<a href="boardList.jsp?page=<%=endPage+1%>">[다음]</a>	
			<%}%>
			<%if(currentPage < maxPage){%>
				<a href="boardList.jsp?page=<%=maxPage%>">[마지막]</a>	
			<%}%>
			
		</div>
	</section>
</body>
</html>





