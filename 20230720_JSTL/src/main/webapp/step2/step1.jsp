<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>회원 정보</h3>
	<br>
	id: ${my.getId()}
	<br>
	pwd: ${my.getPassword()}
	<br>
	name: ${my.getName()}
	<br>
	email: ${my.getEmail()}
</body>
</html>