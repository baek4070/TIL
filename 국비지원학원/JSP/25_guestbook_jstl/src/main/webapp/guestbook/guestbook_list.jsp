<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
			<td><input type="text" name="guestName" style="width:100%;"/></td>
		<tr>
			<td>암호</td>
			<td><input type="password" name="password" style="width:100%;"/></td>
		</tr>
		<tr>
			<td>메시지</td>
			<td><textarea name="message" cols="35" rows="3"></textarea></td>
		</tr>
	</table>
</form>
<hr>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<!-- 방명록 리스트 정보 출력 -->
<h3>방명록 리스트</h3>
<jsp:useBean id="pm" class="util.PageMaker"/>
<c:if test="${!empty param.page}">
	<c:set target="${pm.cri}" property="page" value="${param.page}"/>
</c:if>
<s:query var="r" dataSource="jdbc/MySqlDB" 
sql="SELECT count(*) AS count FROM test_guestbook" />
<c:set target="${pm}" property="totalCount" value="${r.rows[0].count}" />
<h3>${r.rows[0].count}</h3>
<h3>${r.rows[0]['count']}</h3>
<h3>${r.rowsByIndex[0][0]}</h3>
<c:set target="${pm}" property="displayPageNum" value="5"/>

<jsp:useBean id="bookList" class="java.util.ArrayList" 
			 type="List<GuestBook>"/>
<s:query var="rs" dataSource="jdbc/MySqlDB" 
startRow="${pm.cri.startRow}" maxRows="${pm.cri.perPageNum}">
	SELECT * FROM test_guestbook ORDER BY id DESC
</s:query>
<c:forEach var="data" items="${rs.rows}">
	<c:if test="${bookList.add(data)}"/>
</c:forEach>
<c:choose>
	<c:when test="${!empty bookList}">
		<c:forEach var="vo" items="${bookList}">
			<div style="border:1px solid black;padding:10px;">
				메세지 번호 : ${vo.id} <br/>
				손님 이름 : ${vo.guestName} <br/>
				메세지 : ${vo.message} <br/>
				<a href="guestbook_confirm.jsp?id=${vo.id}">[삭제하기]</a>
			</div>
		</c:forEach>	
		<c:forEach var="i" begin="${pm.startPage}" end="${pm.endPage}">
			<a href="guestbook_list.jsp?page=${i}">[${i}]</a>
		</c:forEach>
	</c:when>
	<c:otherwise>
		등록된 메세지가 존재하지 않습니다.
	</c:otherwise>
</c:choose>

<!-- 방명록 리스트 정보 출력 end -->



<!-- 방명록 정보에 따른 paging block 화면 출력 작성 -->


<!-- 방명록 정보에 따른 paging block 화면 출력 end-->

</body>
</html>


 