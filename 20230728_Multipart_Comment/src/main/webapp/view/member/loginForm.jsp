<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>로그인</h3>
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
		${sessionScope.member.getId() }님 이미 로그인 되어있습니다. 
		<a class="button-link" href="${pageContext.request.contextPath }/LogoutController" onclick="return confirm('로그아웃 하시겠습니까?');">로그아웃</a>
	</c:if>
	
	</div>
</div>

<script type="text/javascript">
function checkInsert(form) {
	var r = form;
    if (form.id.value === '' || form.pwd.value  === '') {
        alert("빈칸이 있습니다. 모두 입력해주세요.");
        return false;
    }
    return true;
}

var resultMsg = '<%= request.getAttribute("msg") %>';
if (resultMsg != "null" && resultMsg.trim() !== '') {
    alert(resultMsg);
}

</script>

</body>
</html>