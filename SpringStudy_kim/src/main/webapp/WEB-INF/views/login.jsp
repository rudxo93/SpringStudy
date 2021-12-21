<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	<label>이메일(아이디)</label><input type="text" id="user_email" name="user_email"><br>
	<label>비밀번호</label><input type="password" id="user_password" name="user_password"><br>
	<button type="button" id="login_btn">로그인</button>
	
	<script>
		const login_btn = document.querySelector("#login_btn");
		login_btn.onclick = () => {
			$.ajax({
				type: "post",
				url: "login",
				data: {
					user_email: $("#user_email").val(),
					user_password: $("#user_password").val()
				},
				dayaType: "text",
				success: function(data){
					if(data == 0){
						alert("존재하지 않는 아이디입니다.")
					} else if(data == 1){
						alert("비밀번호가 틀렸습니다.")
					} else if(data == 2){
						alert("로그인 성공.")
						location.href = "index";
					}
				},
				error: function(){
					alert('비동기 통신 오류');
				}
			})
		}
	</script>
</body>
</html>