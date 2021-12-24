<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section>
	<form action="join" method="post">
		<table class="join">
			<tr>
				<th colspan="2"><h1>회원가입</h1></th>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" alt="아이디"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" alt="비밀번호"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" alt="이름"/></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" alt="주소" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" alt="전화번호" /></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" id="acceptBtn" value="회원가입" /></td>
			</tr>
		</table>
	</form>
</section>
<script>
$("#acceptBtn").click(function(){
	if($("input[name=id]").val() == ""){
		alert("아이디를 입력해주세요");
		$("input[name=id]").focus();
	return false;	
	}
	if($("input[name=pass]").val() == ""){
		alert("비밀번호를 입력해주세요");
		$("input[name=pass]").focus();
	return false;	
	}
	if($("input[name=name]").val() == ""){
		alert("이름을 입력해주세요");
		$("input[name=name]").focus();
	return false;	
	}
	if($("input[name=addr]").val() == ""){
		alert("주소를 입력해주세요");
		$("input[name=addr]").focus();
	return false;	
	}
	if($("input[name=phone]").val() == ""){
		alert("전화번호를 입력해주세요");
		$("input[name=phone]").focus();
	return false;	
	}
});
</script>