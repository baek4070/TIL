<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<section>
	<form name="joinForm" action="join" method="post">
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
				<td colspan=2><input type="button" id="acceptBtn" value="회원가입" /></td>
			</tr>
		</table>
	</form>
</section>
<script>
	let btn = document.getElementById("acceptBtn");
	//btn.onclick = function(){
	btn.addEventListener("click",function(){
		let inputs = document.getElementsByTagName("input");
		console.log(inputs);
		for(let i=0; i<inputs.length; i++){
			console.log(inputs[i]);
			let length = inputs[i].value.length;
			if(length == 0){
				alert(inputs[i].alt+"를 작성해 주세요.");
				inputs[i].focus();
				return;
			}
		}
		let form = document.querySelector("form");
		form.submit();
		//joinForm.submit();
	});
</script>
<jsp:include page="footer.jsp"/>














