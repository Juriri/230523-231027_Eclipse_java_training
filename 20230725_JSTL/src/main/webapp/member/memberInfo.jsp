<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="model.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h3>내정보 수정</h3>
	<c:if test="${not empty member}">
	<form action="${pageContext.request.contextPath}/EditController" method="post">
		id: ${member.getId()} <br>
		<input type="hidden" name="id" value="${member.getId()}">
		수정할 패스워드: <input type="text" name="pwd"><br>
		수정할 이름: <input type="text" name="name"><br>
		수정할 이메일 주소: <input type="text" name="email"><br>
		<input type="submit" value="회원 정보 수정">
	</form>
	</c:if>
	</div>
</div>
</body>
</html>