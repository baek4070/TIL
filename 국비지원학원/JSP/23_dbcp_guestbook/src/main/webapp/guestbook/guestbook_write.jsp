<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="util.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String msg="";
	//넘어오는 3가지 파라미터를 요구하기 귀찮음으로 유즈빈을 사용하자
%>
<jsp:useBean id="guestBook" class="vo.GuestBook"/>
<jsp:setProperty name="guestBook" property="*"/>
<%-- <%=guestBook%> bean값 세팅 결과확인했으니 주석처리--%>
<%
	Connection conn= DBCPUtil.getConnection();
	PreparedStatement pstmt = null;
	String sql = "INSERT INTO test_guestbook"
				+"(guestName,password,message) VALUES(?,?,?)";
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, guestBook.getGuestName());
		pstmt.setString(2, guestBook.getPassword());
		pstmt.setString(3, guestBook.getMessage());
		msg = (pstmt.executeUpdate() > 0) ? "방명록 등록 성공" : "방명록 등록 실패";
	}catch(Exception e){
		msg = "방명록 등록 실패";
		System.out.println(e.toString());
	}finally{
		DBCPUtil.close(pstmt,conn);
	}
	
%>

<!DOCTYPE html>
<html>
<head>
	<title>방명록 메시지 작성 확인</title>
</head>
<body>

<!-- 방명록 작성 후 처리 결과 출력 code 작성 -->
<h3><%=msg%></h3>
<!-- 방명록 작성 후 처리 결과 출력 code 작성 end-->
<a href="guestbook_list.jsp">[목록 보기]</a>
</body>
</html>