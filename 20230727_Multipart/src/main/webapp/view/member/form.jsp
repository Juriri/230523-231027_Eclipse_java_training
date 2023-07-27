<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h3>회원가입</h3>
<div class="container">
	<div class="menu-container">
	<h3>회원가입</h3>
	<form name="registerForm" action="${pageContext.request.contextPath}/JoinController" method="post">
		Id: <input type="text" name="id"><br>
		Password: <input type="password" name="pwd"><br>
		Name: <input type="text" name="name"><br>
		Email: <input type="text" name="email"><br>
		Addr: <input type="text" name="addr"><br>
		<label>
            <input type="radio" name="type" value="1"> 판매자
            <input type="radio" name="type" value="2"> 구매자
        </label><br>
		<input type="reset" value="취소">
		<input type="submit" value="회원가입" onclick="return checkInsert(this.form);">
		<a href="loginForm.jsp">로그인 페이지 이동</a>
	</form>
	</div>
</div>
<script type="text/javascript">
function checkInsert(form) {
	var r = form;
    if (form.id.value === '' || form.pwd.value === '' || form.name.value === '' || form.email.value === '' || form.addr.value === '' || !(form.type[0].checked || form.type[1].checked)) {
        alert("빈칸이 있습니다. 모두 입력해주세요.");
        return false;
    }
    return true;
}
</script>
</body>
</html>