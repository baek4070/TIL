<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<f:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sqlResult.jsp</title>
</head>
<body>
	${param.id}-${param.pass}-${param.name} <br/>
	${param.addr}-${param.gender}-${param.age} <br/>
	${param.phone} <br/><hr/>
<c:catch var="e">
	<s:setDataSource 
				var="conn" 
				driver="com.mysql.cj.jdbc.Driver" 
				url="jdbc:mysql://localhost:3306/smartWeb" 
				user="smartWeb" 
				password="12345"/>
	<h3>${conn}</h3>
	<!-- executeQuery -->
	<%-- 
	<s:query var="r" dataSource="${conn}">
		SELECT * FROM test_member
	</s:query>
	 --%>
	<h3>전체 리스트</h3>
	<s:query var="r" sql="SELECT * FROM test_member" dataSource="jdbc/MySqlDB" />
	<c:forEach var="data" items="${r.rows}">
		<c:out value="${data['num']}"/>&nbsp;
		<c:out value="${data['id']}"/>&nbsp;
		<c:out value="${data['pass']}"/>&nbsp;
		<c:out value="${data['name']}"/>&nbsp;
		<c:out value="${data['addr']}"/>&nbsp;
		<c:out value="${data['phone']}"/>&nbsp;
		<c:out value="${data['gender']}"/>&nbsp;
		<c:out value="${data['age']}"/>&nbsp;
		<c:out value="${data['regdate']}"/>&nbsp;
		<br/>
	</c:forEach>
	
	<!-- 정보 삽입 -->
	<%-- <s:update dataSource="${conn}"> --%>
	<s:update dataSource="jdbc/MySqlDB">
		INSERT INTO test_member 
		VALUES(null,'${param.id}','${param.pass}'
		,'${param.name}','${param.addr}',
		'${param.phone}','${param.gender}'
		,${param.age},now())
	</s:update>
	
	<h3>삽입 후 실행 결과 검색</h3>
	<!-- startRow 검색할 시작 인덱스 , maxRows 검색할 행의 개수 -->
	<s:query var="rs" dataSource="jdbc/MySqlDB" startRow="0" maxRows="5">
		SELECT * FROM test_member ORDER BY num DESC
	</s:query> 
	<c:forEach var="d" items="${rs.rows}">
		${d.num} &nbsp;
		${d.id} &nbsp;
		${d.pass} &nbsp;
		${d.name} &nbsp;
		${d.addr} &nbsp;
		${d.phone} &nbsp;
		${d.gender} &nbsp;
		${d.age} &nbsp;
		${d.regdate} &nbsp;
		<f:formatDate value="${d.regdate}" pattern="yyyy-MM--dd hh:mm:ss"/>
		<br/>
	</c:forEach>
	
	<c:set var="id" value="id001"/>
	<c:set var="pass" value="pw991"/>
	<s:query var="rss" dataSource="jdbc/MySqlDB">
		SELECT * FROM test_member WHERE id = ? AND pass = ? 
		<s:param>${id}</s:param>
		<s:param>${pass}</s:param>
	</s:query>
	<table border="1">
		<tr>
			<c:forEach var="columnName" items="${rss.columnNames}">
			<th>${columnName}</th>
			</c:forEach>
		</tr>
		<c:forEach var="rowIndex" items="${rss.rowsByIndex}">
			<tr>
				<c:forEach var="columnValue" items="${rowIndex}">
					<td>${columnValue}</td>
				</c:forEach>
			</tr>
		</c:forEach>
		<s:update var="result" dataSource="jdbc/MySqlDB"
		sql="DELETE FROM test_member where id='${param.id}'"/>
	</table>
	<br/> result:${result}
	
</c:catch>
<c:if test="${!empty e}">
	에러메세지 : <c:out value="${e.message}"/>
</c:if>
</body>
</html>













