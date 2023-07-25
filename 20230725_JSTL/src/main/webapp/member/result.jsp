<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
		<h3>메뉴</h3>
		<c:if test = "${not empty sessionScope.member }">
			${sessionScope.member.getId() }님 로그인<br>
			${sessionScope.member.getName() }님 환영합니다. !<br><br>
			<a href= "${pageContext.request.contextPath}/SearchController">내 정보 수정</a><br>
			<a href= "${pageContext.request.contextPath}/LogoutController">로그아웃</a><br>
			<a href= "${pageContext.request.contextPath}/DelController">회원 탈퇴</a><br>
			<a href= "${pageContext.request.contextPath}/WriteController">게시글 작성</a><br>
			<a href= "${pageContext.request.contextPath}/ListController">게시글 보기</a><br>
		</c:if>
		
		<c:if test = "${empty sessionScope.member }">
		<h3>로그인 실패</h3>
		<a href="${pageContext.request.contextPath}/member/loginForm.jsp">로그인 페이지 이동</a>
		</c:if>
	</div>
</div>
</body>
</html>