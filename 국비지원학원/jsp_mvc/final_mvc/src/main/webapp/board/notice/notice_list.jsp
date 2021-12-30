<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../common/header.jsp"/>
<section>
	<table>
		<tr>
			<th colspan="4">
				<h2>공지사항</h2>
			</th>
		</tr>	
		<tr>
			<td colspan="4">
				<form action="noticeSearch.do" method="GET">
					<select name="searchName">
						<option value="author">작성자<option>
						<option value="title">제목<option>
					</select>
					<input type="text" name="serchValue"/>
					<input type="submit" value="검색"/>
				</form> 
			</td>
		</tr>
		<c:if test="${!empty member and member.id eq 'admin'}">
			<tr>
				<td colspan="4">
					<a href="noticeWrite.do">공지글 작성</a>
				</td>
			</tr>
		</c:if>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<!-- 공지글 리스트 -->
		<!-- 페이징 정보 -->
	</table>
</section>
<jsp:include page="../../common/footer.jsp"/>









