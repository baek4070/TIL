<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrap">
		<div>
			<h1><a href="/">MAIN</a></h1>
		</div>
		<article>
			<h3>SIGN IN</h3>
			<form action="signInPost" method="POST">
				<table>
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="uid" placeholder="USER ID" required/>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<input type="password" name="upw" placeholder="USER PW" required/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="checkbox" name="useCookie"/>
							로그인 정보 저장
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="SIGN IN"/>
							<input type="button" onclick="location.href='signUp';" value="SIGN UP"/>
						</td>
					</tr>
				</table>
			</form>
		</article>
	 </div>
	 	 <div class="alertDiv" id="alertDiv">
	 	<div class="contentWrap">
			<div class="textWrap" id="textWrap">
				<span id="message"></span> <br/>
				<span id="time"></span>
			</div>	 	
			<div id="closeBtn" class="close">닫기</div>
	 	</div>
	 </div>
	 
	  <script>
	 	var msg = '${message}';
	 	var alertDiv = document.getElementById("alertDiv");
	 	
	 	if(msg != ''){
	 		document.getElementById("message").innerHTML = msg;
	 		}
	 	}
	 	
	 	document.getElementById("closeBtn").onclick = stop;
	 	
	 	function stop(){
	 		alertDiv.style.display = "none";
	 	}
	 	
	 	
	 	
	 	
	 	
	 </script>
</body>
</html>