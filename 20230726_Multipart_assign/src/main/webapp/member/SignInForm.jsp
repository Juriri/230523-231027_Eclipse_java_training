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
	<form action="${pageContext.request.contextPath}/control/Login?type=Login.do" method="post">
		Id: <input type="text" name="id"><br>
		Password: <input type="password" name="pwd"><br>
		<input type="reset" value="취소">
		<input type="submit" value="로그인" onclick="return checkInsert(this.form);">
	</form>
	<a href="${pageContext.request.contextPath}/member/SignUp.jsp">회원가입</a>
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
</script>

</body>
</html>