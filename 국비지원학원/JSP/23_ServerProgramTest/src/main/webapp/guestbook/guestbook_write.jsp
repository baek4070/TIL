<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../connection.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메시지 작성 확인</title>
</head>
<body>
<!-- 삭제 요청에 필요한 정보 전달 -->
<%
	request.setCharacterEncoding("UTF-8"); //post로 넘어오는거니까 인코딩 설정먼저
	String guestName = request.getParameter("guestName");
	String password = request.getParameter("password");
	String message = request.getParameter("message");
	
	Statement stmt = null;
	stmt = conn.createStatement();
		
	try{
			
		if(guestName == null || password == null || message == null ||guestName ==""||password == ""||message ==""){
			out.print("<h2>방명록 등록 실패</h2>");
		}else{
			String sql = "INSERT INTO test_guestbook(guestName,password,message)"+" VALUES('"+guestName+"','"+password+"','"+message+"')";
			System.out.println("sql : " + sql);
			int result = stmt.executeUpdate(sql);
			if(result > 0){
				out.print("<h2>방명록 등록 성공</h2>");
			}else{
				out.print("<h2>방명록 등록 실패</h2>");
			}
		}
	}catch(Exception e){
		out.print("<h2>"+e.toString()+"</h2>");
	}finally{
		stmt.close();
		conn.close();
	}
%>
	방명록에 메시지를 남겼습니다<br/>
<!-- 방명록 작성 후 처리 결과 출력 code 작성 end-->
	<a href=guestbook_list.jsp>[목록보기]</a>
</body>
</html>