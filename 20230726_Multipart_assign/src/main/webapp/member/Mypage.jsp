<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="menu-container">
	<h3>내정보 수정</h3>
	<c:if test="${not empty sessionScope.member}">
	<form action="${pageContext.request.contextPath}/control/Mypage?type=Update" method="post">
		id: ${member.getId()} <br>
		<input type="hidden" name="id" value="${sessionScope.member.getId()}">
		수정할 패스워드: <input type="text" name="pwd" value="${sessionScope.member.getPwd()}"><br>
		수정할 이름: <input type="text" name="name" value="${sessionScope.member.getName()}"><br>
		수정할 이메일 주소: <input type="text" name="email" value="${sessionScope.member.getEmail()}"><br>
		<input type="submit" value="회원 정보 수정">
	</form>
	<a href="${pageContext.request.contextPath }/home.jsp">홈화면</a>
	</c:if>
	
	<c:if test="${empty sessionScope.member}">
	로그인 정보가 없습니다. 로그인 먼저 해주세요 <br>
	<a href="${pageContext.request.contextPath }/control/Login?type=Login">로그인하기</a>
	</c:if>
	</div>
</div>
</body>
</html>