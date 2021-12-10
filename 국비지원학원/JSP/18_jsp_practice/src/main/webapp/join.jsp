<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="joinCheck.jsp" method="POST">
<table id=jointb>
	<tr>
		<th colspan="2">회원가입</th>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"/></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="pw"/></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name="addr"/></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="tel"/></td>
	</tr>
	<tr>
		<td>성별</td>
		<td>
			<label>
				<input type="radio" name="gender" value="male"/>
				남성
			</label>
			<label>
				<input type="radio" name="gender" value="female"/>
				여성
			</label>
		</td>
	</tr>
	<tr>
		<td>나이</td>
		<td><input type="text" name="age"/></td>
	</tr>
	<tr>
		<td colspan="2"><button type="submit" value="회원가입">회원가입</button></td>
	</tr>
</table>
</form>