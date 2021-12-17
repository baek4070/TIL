<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>방명록 메시지 목록</title>
</head>
<style>
	
</style>
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
			<td><input type="text"  name="guestName" style="width:100%;"/></td>
		<tr>
			<td>암호</td>
			<td><input type="password" name="password" style="width:100%;"/></td>
		</tr>
		<tr>
			<td>메시지</td>
			<td><textarea cols="35" rows="3" name="message" ></textarea></td>
		</tr>
	</table>
</form>
<hr>

<!-- 방명록 리스트 정보 출력 -->
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "util.*" %>
<%@ page import = "vo.*" %>
<%
	int currentPage = 1;
	int pageCount = 5;
	int totalCount = 0;
	int start = 0;
	int end = 0;
	int max = 0 ;
	
%>

<%
	request.setCharacterEncoding("utf-8");
	String paramPage = request.getParameter("page");
	if(paramPage != null){
		currentPage = Integer.parseInt(paramPage);
	}

	Connection conn = DBCPUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<GuestBook> bookList = new ArrayList<>();
	
	String sql = "SELECT * FROM test_guestbook "
				+" ORDER BY id DESC limit ?, ?";
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (currentPage-1) * pageCount );
		pstmt.setInt(2, pageCount);
		rs = pstmt.executeQuery();
		while(rs.next()){
			GuestBook vo = new GuestBook(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4)
			);
			bookList.add(vo);
		}
		DBCPUtil.close(pstmt,rs);
		
		// 페이징 블럭 로직
		sql = "SELECT count(*) FROM test_guestbook;" ;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()){
			totalCount = rs.getInt(1);
		}
		// totalCount = 1289;
		//         7-1       / 5 (1.2) +1 = 2;
		max = (totalCount-1) / pageCount + 1;
		System.out.println(max);
		max = (int)(Math.ceil(totalCount /(double)pageCount));
		System.out.println(max);
		end  = (int)Math.ceil(currentPage/(double)pageCount) * pageCount;
		start = (end - pageCount)+1;
		if(end > max) end = max;
	}catch(Exception e){
		e.printStackTrace();
	} finally{
		DBCPUtil.close(rs,pstmt,conn);
	}
%>


<!-- 방명록 리스트 정보 출력 end -->
<% if(!bookList.isEmpty()){%>
<!-- 방명록 리스트가 비어 있지 않으면 -->
	<table border="1" cellspacing = "0" cellpadding="10">
		<%for(GuestBook vo : bookList){%>
			<tr>
				<td>
					메세지 번호 :<%=vo.getId()%><br/>
					손님 이름 : <%=vo.getGuestName()%><br/>
					메시지 : <%=vo.getMessage()%><br/>
					<a href="guestbook_confirm.jsp?id=<%=vo.getId()%>">[삭제]</a>
				</td>
			</tr>
		<%}%>
	</table>
<!-- 방명록 정보에 따른 paging block 화면 출력 작성 -->
	<%if(start > 1){%>
		<a href="guestbook_list.jsp?page=<%=start-1%>">[이전]</a>
	<%} %>

	<%for(int i=start; i<=end; i++){ %>
		<%if(currentPage == i){%>
		[<%=i%>]
		<%}else{ %>
		<a href="guestbook_list.jsp?page=<%=i%>">[<%=i%>]</a>
		<%}%>
	<%}%>
	<%if(end < max){%>
		<a href="guestbook_list.jsp?page=<%=end+1%>">[다음]</a>
	<%} %>
<!-- 방명록 정보에 따른 paging block 화면 출력 end-->
<%}else{ %>
<!-- 방명록 리스트가 비어 있으면 -->
등록된 메세지가 없습니다.
<%}%>
</body>
</html>