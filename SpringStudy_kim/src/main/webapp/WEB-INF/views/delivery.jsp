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
		<!-- 1 . 배송 받을 사람( 이름 ) 변수명 customer_name  -->
		고객명 : <input type="text" name="customer_name"><br>
		<!-- 2 . 배송지 ( 주소 ) 변수명 customer_addr  -->
		배송지(주소) : <input type="text" name="customer_addr"><br>
		<!-- 3 . 연락처 변수명 customer_phone -->
		고객 연락처 : <input type="tel" name="customer_phone"><br>
		<!-- 4 . 택배기사님께 요청사항 변수명 customer_etc  -->
		요청사항 : <input type="text" name="customer_etc"><br>
		<!-- 서브밋(form의 action = delivery-request)  -->
		<input type="submit" value="전송">
	</form>
	<!-- controller 명 DeliveryController  -->
	<!-- Model 객체명 CustomerModel  -->

	<!-- view(jsp) 파일로 변환  -->
	<!-- deliveryInfo.jsp  -->
	<!-- 
고객명 : 김일
배송지(주소) : 부산시 양정동
고객 연락처 : 010-1111-2222
요청사항 : 문 앞에 두고 가주세요.
 -->
</body>
</html>