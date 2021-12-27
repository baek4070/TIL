<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
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
					<input type="button" id="acceptBtn" value="로그인" />
				</td>
			</tr>
		</table>
	</form>
</section>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$("#acceptBtn").click(function(){
		var isChecked = true;
		$("input").each(function(){
			if(this.type != 'checkbox' &&
				$(this).val().length == 0){
				let alt = $(this).attr("alt");
				alert(alt+"를 작성해주세요.");
				$(this).focus();
				isChecked = false;
				return false;
			}
		});
		if(isChecked){
			$("#loginForm").submit();
		}
	});
</script>
<jsp:include page="footer.jsp"/>












