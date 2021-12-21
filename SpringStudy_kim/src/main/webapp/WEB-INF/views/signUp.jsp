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
	<label>아이디</label><input type="text" id="signUp_id"> <button type="button" id="id_check_btn">중복확인</button><br>
	<label>비밀번호</label><input type="password" id="signUp_password"><br>
	<label>이름</label><input type="text" id="signUp_name"><br>
	<label>연락처</label><input type="tel" id="signUp_phone"><br>
	<button type="button" id="signUp_btn">가입하기</button>
	
	<script type="text/javascript">
		const id_check_btn = document.querySelector("#id_check_btn");
		const signUp_btn = document.querySelector("#signUp_btn");
	
		id_check_btn.onclick = () => {
			$.ajax({
				type: "post",
				url: "idCheck",
				data: {
					user_email: document.querySelector("#signUp_id").value
				},
				dataType: "text",
				success: function(data){
					if(data == 0) {
						alert("사용가능한 아이디입니다.");
					}else if(data == 1){
						alert("이미 존재하는 아이디입니다.");
					}
				},
				error: function(){
					alert("비동기처리 오류");
				}
			})
		}
		
		signUp_btn.onclick = () => {
			let signUpData = {
					user_email: $("#signUp_id").val(),
					user_password: $("#signUp_password").val(),
					user_name: $("#signUp_name").val(),
					user_phone: $("#signUp_phone").val()
			};
			
			$.ajax({
				type: "POST",
				url: "signUp",
				data: JSON.stringify(signUpData),
				dataType: "text",
				contentType: "application/json; charset=UTF-8",
				success: function(data){
					if(data == 0){
						alert('회원가입 실패');
					}else if(data == 1){
						alert('회원가입 성공!');
						location.href = 'index';
					}
				},
				error: function(){
					alert("비동기처리 오류");
				}
			})
		}
	</script>
</body>
</html>