<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../connection.jsp"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메시지 목록</title>
</head>
<body>
	<!-- 방명록 작성 전달을 위한 form tag 완성 -->
<form action="guestbook_write.jsp" method="post">
	<table>
		<tr>
			<td colspan=3><h1>방명록 작성</h1></td>
		</tr>
		<tr>
			<td colspan=2></td>
			<td rowspan="4"><input type="submit" value="메시지 남기기" style="width:100%;height:100px;margin-left:20px;"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text"  style="width:100%;" name="guestName"/></td>
		<tr>
			<td>암호</td>
			<td><input type="password" style="width:100%;"name="password"/></td>
		</tr>
		<tr>
			<td>메시지</td>
			<td><textarea cols="35" rows="3" name="message"></textarea></td>
		</tr>
	</table>
</form>
<hr>


<%
int currentPage = 1; // 요청 들어온 현재 페이지 번호
int pageCount = 5;  // 한번에 보여줄 게시물의 수
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
PreparedStatement pstmt = null;
ResultSet rs = null;
String result = "";

//페이징 블럭 처리
String sql ="SELECT count(*) FROM test_guestbook";
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
sql = "SELECT * FROM test_guestbook "
			+"ORDER BY id DESC limit ? , ?";
pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, startRow);
pstmt.setInt(2, endRow);
rs = pstmt.executeQuery();
%>	
<!-- 방명록 리스트 정보 출력 -->

<section>
		<br/>
				<%
				if(rs.next() != true){		
					out.print("등록된 메시지가 없습니다.");
					
				}else{
					%>	
					<div style="border:1px solid red;">
					메시지 번호 :<%=rs.getInt("id")%><br/>
					손님이름 :<%=rs.getString("guestName")%><br/>
					메시지 :<%=rs.getString("message")%><br/>
					<a href="guestbook_confirm.jsp?id=<%=rs.getInt("id")%>">[삭제하기]</a><br/>
					</div><br/>
				<%
				}
				while(rs.next()){
				%>	
				<div style="border:1px solid red;">
				메시지 번호 :<%=rs.getInt("id")%><br/>
				손님이름 :<%=rs.getString("guestName")%><br/>
				메시지 :<%=rs.getString("message")%><br/>
				<a href="guestbook_confirm.jsp?id=<%=rs.getInt("id")%>">[삭제하기]</a><br/>
				</div><br/>
			<%
				}
			%>
<!-- 방명록 리스트 정보 출력 end -->
		
<!-- 방명록 정보에 따른 paging block 화면 출력 작성 -->
		<div class="pageWrap">
			<% if(currentPage != 1){%>	
				<a href="guestbook_list.jsp?page=1">[처음]</a>
			<%}%>
			<%if((startPage-1) > 0) {%>
				<a href="guestbook_list.jsp?page=<%=startPage-1%>">[이전]</a>
			<%}%>
			<%for(int i=startPage; i<=endPage;i++){ %>
				<a href="guestbook_list.jsp?page=<%=i%>">[<%=i%>]</a>
			<%}%>
			<%if(endPage < maxPage){%>
				<a href="guestbook_list.jsp?page=<%=endPage+1%>">[다음]</a>	
			<%}%>
			<%if(currentPage < maxPage){%>
				<a href="guestbook_list.jsp?page=<%=maxPage%>">[마지막]</a>	
			<%}%>
			
		</div>
	</section>

<!-- 방명록 정보에 따른 paging block 화면 출력 end-->
</body>
</html>