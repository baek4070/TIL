<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!-- member.jsp -->
<!-- 
	criteria = page = 1
			   perPageNum = 5	
    pageMaker = totalCount 전체게시물 수
              = displayPageNum  한번에 보여줄 block 수
 -->
<jsp:useBean id="pm" class="util.PageMaker" />
<c:set target="${pm}" property="displayPageNum" value="5"/>
<c:set target="${pm.cri}" property="perPageNum" value="3"/>
<!-- 사용자가 요청한 페이지(selectPage) 정보 -->
<c:if test ="${!empty param.selectPage}">
	<c:set target="${pm.cri}" property="page" 
				value="${param.selectPage}"/>
</c:if> 
<!-- 전체 회원 수 totalCount-->
<s:query var="r" dataSource="jdbc/MySqlDB">
	SELECT count(*) AS count FROM smart_member 
	WHERE u_id != 'admin' AND u_join = 'Y' 
</s:query>
<c:set target="${pm}" property="totalCount" value="${r.rows[0].count}"/>
<!-- pageMaker 처리 완료 -->

<s:query var="rs" dataSource="jdbc/MySqlDB" 
startRow="${pm.cri.startRow}" maxRows="${pm.cri.perPageNum}">
	SELECT * FROM smart_member 
	WHERE u_id != 'admin' AND u_join = 'Y' 
	ORDER BY u_num DESC
</s:query>

<table border=1>
	<tr>
		<th colspan=4>${pm}</th>
	</tr>
	<tr>
		<th colspan="4">회원정보</th>
	</tr>
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>회원등록일</th>
		<th>기타</th>
	</tr>
	<tr>
		<td>rowCount</td>
		<td colspan="3">${rs.rowCount}</td>
	</tr>
	<c:choose>
		<c:when test="${rs.rowCount > 0}">
			<!-- ${rs.rowCount} 검색된 행의 개수 -->
			<c:forEach var="row" items="${rs.rows}">
				<tr>
					<td>${row['u_num']}</td>
					<td>${row['u_id']}</td>
					<td>
						<f:formatDate value="${row['u_regdate']}" 
							pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<td>
						<button type="button" onclick="selectBtn('memberUpdate','${row.u_num}');">수정</button>
						<button type="button" onclick="selectBtn('memberDelete','${row.u_num}');">삭제</button>
					</td>
				</tr>
			</c:forEach>
			<!-- paging block -->
			<tr>
				<td colspan="4">
					<!-- [6][7][8][9][10] -->
					<c:if test="${pm.prev}">
						<a href="main.jsp?page=member&selectPage=${pm.startPage-1}">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${pm.startPage}" end="${pm.endPage}">
						<a href="main.jsp?page=member&selectPage=${i}">[${i}]</a>
					</c:forEach>
					<c:if test="${pm.next}">
						<a href="main.jsp?page=member&selectPage=${pm.endPage + 1}">[다음]</a>
					</c:if>
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="4">등록된 회원정보가 없습니다.</td>
			</tr>
		</c:otherwise>	
	</c:choose>
</table>
<script>
	function selectBtn(page, u_num){
		location.href="main.jsp?page="+page+"&u_num="+u_num;
	}
</script>












