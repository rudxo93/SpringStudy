<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="delivery-request" method="post">
		고객명 : ${customerModel.customer_name }<br>   <!-- customerModel 객체의 customer_name값을 가져온다.  -->
		배송지(주소) : ${customerModel.customer_addr }<br>
		고객 연락처 : ${customerModel.customer_phone }<br>
		요청사항 : ${customerModel.customer_etc }<br>
	</form>
</body>
</html>