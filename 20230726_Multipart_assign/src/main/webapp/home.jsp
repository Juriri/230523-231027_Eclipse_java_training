<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h3>쇼핑몰 구경하기</h3>
	<c:if test="${empty sessionScope.member}">
		<form name="loginForm" action="${pageContext.request.contextPath}/control/Login" method="get">
			<input type="hidden" name="type" value="Login">
    		<input type="button" value="Login" onclick="submitForm()">
		</form>
	</c:if>
		
	<c:if test="${not empty sessionScope.member}">
		${sessionScope.member.getId() }님 환영합니다.!<br>
		<a class="button-link" href="${pageContext.request.contextPath }/control/Login?type=Logout" onclick="return confirm('로그아웃 하시겠습니까?');">로그아웃</a>
		<a class="button-link" href="${pageContext.request.contextPath }/control/Mypage?type=Mypage">내 정보 수정</a>
		<a class="button-link" href="${pageContext.request.contextPath }/control/Mypage?type=Delete" onclick="return confirm('탈퇴 하시겠습니까?');">회원탈퇴</a>
	</c:if>
	
	<a class="button-link" href="${pageContext.request.contextPath }/control/Board">게시글 목록</a>
	</div>
</div>

<script>
    function submitForm() {
        // This function will be called when the button is clicked
        document.loginForm.submit(); // Submit the form
    }
    
</script>

</body>
</html>