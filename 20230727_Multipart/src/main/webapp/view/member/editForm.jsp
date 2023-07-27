<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="menu-container">
	<h3>내정보 수정</h3>
	<c:if test="${not empty sessionScope.member}">
	<form action="${pageContext.request.contextPath}/EditController" method="post">
		id: ${member.getId()} <br>
		<input type="hidden" name="id" value="${member.getId()}">
		<input type="hidden" name="type" value="${member.getType()}">
		수정할 패스워드: <input type="text" name="pwd" value="${member.getPwd()}"><br>
		수정할 이름: <input type="text" name="name" value="${member.getName()}"><br>
		수정할 이메일: <input type="text" name="email" value="${member.getEmail()}"><br>
		수정할 주소: <input type="text" name="addr" value="${member.getAddr()}"><br>
		<input type="submit" value="회원 정보 수정">
	</form>
	<a href="${pageContext.request.contextPath }/view/member/result.jsp">홈화면</a>
	</c:if>
	
	<c:if test="${empty sessionScope.member}">
	로그인 정보가 없습니다. 로그인 먼저 해주세요 <br>
	<a href="${pageContext.request.contextPath }/view/member/loginForm.jsp">로그인하기</a>
	</c:if>
	</div>
</div>
<script type="text/javascript">
var resultMsg = '<%= request.getAttribute("msg") %>';
console.log(resultMsg);
if (resultMsg != "null" && resultMsg.trim() !== '') {
    alert(resultMsg);
}

</script>
</body>
</html>