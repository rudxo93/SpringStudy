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
	<form id="login-form">
		아이디 <input name="loginid"> <br>
		비밀번호 <input type="password" name="loginpassword">
		<button type="button" id="login-btn">로그인</button>
	</form>
	<script type="text/javascript">
		const lform = document.querySelector('#login-form');
		const lbnt = document.querySelector('#login-btn');
		
		lbnt.onclick = () => {
			let formData = new FormData(lform);
			let loginid = formData.get('loginid');
			let loginpassword = formData.get('loginpassword');
			
			$.ajax({
				type: "get",
				url: "login-submit/" + loginid + "/" + loginpassword,
				dataType: "text",
				success: function(data){
					alert(data);
				},
				error: function(){
					alery('요청실패');
				}
			})
		}
	</script>
</body>
</html>