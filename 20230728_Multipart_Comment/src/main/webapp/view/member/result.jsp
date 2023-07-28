<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="menu-container">
	<h3>login</h3>
	<c:if test="${empty sessionScope.member}">
		<form action="${pageContext.request.contextPath}/LoginController" method="post">
			Id: <input type="text" name="id"><br>
			Password: <input type="password" name="pwd"><br>
			<input type="reset" value="초기화">
			<input type="submit" value="로그인" onclick="return checkInsert(this.form);">
		</form>
		<a href="${pageContext.request.contextPath}/view/member/form.jsp">회원가입</a>
	</c:if>
	<c:if test="${not empty sessionScope.member}">
		${sessionScope.member.getId() }님 환영합니다. <br>
		<a class="button-link" href="${pageContext.request.contextPath }/SearchController">내 정보 수정</a><br>
		<a class="button-link" href="${pageContext.request.contextPath }/LogoutController" onclick="return confirm('로그아웃 하시겠습니까?');">로그아웃</a><br>
		<a class="button-link" href="${pageContext.request.contextPath }/DelController" onclick="return confirm('회원 탈퇴 하시겠습니까?');">회원 탈퇴</a><br>
		
		
		<c:if test="${sessionScope.member.getType() == 1}">
		    <a class="button-link" href="${pageContext.request.contextPath}/seller/List">쇼핑몰(판매자)</a><br>
		</c:if>
		<c:if test="${sessionScope.member.getType() == 2}">
		    <a class="button-link" href="${pageContext.request.contextPath}/order/list">쇼핑몰(구매자)</a><br>
		</c:if>
	</c:if>
	</div>
</div>
</body>
</html>