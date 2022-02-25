<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- mngt/main.jsp -->
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container">
	<h1>MANAGEMENT MAIN</h1>
	<!-- memberList -->
	<table class="container table tabled-bordered">
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>권한</td>
			<td>회원가입일</td>		
			<td>최종방문일</td>
			<td>활성화여부</td><!-- 탈퇴여부 -->
			<td>권한선택</td>
		</tr>
		<c:choose>
			<c:when test="${!empty memberList}">
				<c:forEach var="member" items="${memberList}">
				<tr>	
					<td>${member.u_no}</td>
					<td>${member.u_id}</td>
					<td>${member.u_name}</td>
					<td>
						<select>
							<c:forEach var="auth" items="${member.authList}">
								<c:if test="${auth.u_auth eq 'ROLE_USER'}">
									<option value="ROLE_USER">일반사용자</option>
								</c:if>
								<c:if test="${auth.u_auth eq 'ROLE_MEMBERSHIP'}">
									<option value="ROLE_MEMBERSHIP">매니저</option>
								</c:if>
								<c:if test="${auth.u_auth eq 'ROLE_MASTER'}">
									<option value="ROLE_MASTER">관리자</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td>
						<f:formatDate value="${member.u_date}" 
							pattern="yyyy-MM-dd (E) HH:mm"/>
					</td>
					<td>
						<f:formatDate value="${member.u_visit_date}" 
							pattern="yyyy-MM-dd (E) HH:mm"/>
					</td>
					<td>
						<select>
							<option value="y" 
							    ${member.u_withdraw eq 'y' ? 'selected' : ''}>비활성화</option>
							<option value="n" 
								${member.u_withdraw eq 'n' ? 'selected' : ''}>활성화</option>
						</select>
					</td>
					<td>
						<select>
							<option disabled selected>권한선택</option>
							<option value="ROLE_USER">일반사용자</option>
							<option value="ROLE_MEMBERSHIP">매니저</option>
							<option value="ROLE_MASTER">관리자</option>
						</select>
					</td>
				</tr>
				
				
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th colspan="8">등록된 회원정보가 없습니다.</th>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</table>
</div>
</body>
</html>





