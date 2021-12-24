<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section>
	<form id="loginForm" action="login" method="post">
		<table class="login">
			<tr>
				<th colspan="3"><h1>로그인</h1></th>
			</tr>
			<tr>
				<td>아이디</td>
				<td colspan="2"><input type="text" name="id" alt="아이디" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td colspan="2"><input type="password" name="pass" alt="비밀번호" /></td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="checkbox" id="login" name="login" />
				 	<label for="login">로그인 상태 유지</label>
				 </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" id="acceptBtn" value="로그인" />
				</td>
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
});
</script>
