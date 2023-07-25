<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member_style.css">
</head>
<body>
<div class="container">
	<div class="menu-container">
	<h3>login</h3>
	<form action="${pageContext.request.contextPath}/LoginController" method="post">
		Id: <input type="text" name="id"><br>
		Password: <input type="password" name="pwd"><br>
		<input type="reset" name="login" value="취소">
		<input type="submit" name="" value="로그인">
	</form>
	<a href="${pageContext.request.contextPath}/member/form.jsp">회원가입</a>
	</div>
</div>
</body>
</html>