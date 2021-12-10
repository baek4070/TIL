<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logOut.jsp</title>
</head>
<body>
	<%
		//session.removeAttribute("loginMember");
		// 29A9B89FE9002C936EC74E4F227CB65C
		session.invalidate();
		// 95C366BBC4E9255A5EFEE1E93EC26B8F
		System.out.println(session.getId());
		// 95C366BBC4E9255A5EFEE1E93EC26B8F
		// Cookie 삭제
		Cookie cookie = new Cookie("id","");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	%>
	<script>
		alert('로그아웃 성공');
		location.href="index.jsp";
	</script>
</body>
</html>










