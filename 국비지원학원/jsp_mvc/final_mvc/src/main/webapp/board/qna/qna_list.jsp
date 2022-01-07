<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../common/header.jsp"/>
<!-- qna_list.jsp -->
<section>
	<table>
		<tr>
			<th colspan="8"><h2>질문과 답변 목록</h2></th>
		</tr>
		
		<!-- 로그인 되어있다면 직문작성하러가기 테이블이 보이게끔 처리 -->
		<c:if test="${!empty member}">
			<tr>
				<td colspan="8">
					<a href="boardWrite.bo">질문 작성하러 가기</a>
				</td>
			</tr>
		</c:if>
		
		<!--
			 request 질문과 답변 목록
			 ${list} 
		 -->
		 <tr>
		 	<th>글번호</th>
		 	<th>제목</th>
		 	<th>ref</th>
		 	<th>seq</th>
		 	<th>lev</th>
		 	<th>작성자</th>
		 	<th>작성시간</th>
		 	<th>조회수</th>
		 </tr>
		 <tr>
		 	<td></td>
		 	<td></td>
		 	<td></td>
		 	<td></td>
		 	<td></td>
		 	<td></td>
		 	<td></td>
		 	<td></td>
		 </tr>
		 
		<!-- 페이징 블럭 -->
	</table>
</section>
<jsp:include page="../../common/footer.jsp"/>
