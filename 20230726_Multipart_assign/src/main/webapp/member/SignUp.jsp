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
	<h3>ȸ������</h3>
	<form name="registerForm" action="${pageContext.request.contextPath}/control/signup" method="post">
		Id: <input type="text" name="id"><br>
		Password: <input type="password" name="pwd"><br>
		Name: <input type="text" name="name"><br>
		Email: <input type="text" name="email"><br>
		<input type="reset" value="���">
		<input type="submit" value="ȸ������" onclick="return checkInsert(this.form);">
		<a href="SignInForm.jsp">�α��� ������ �̵�</a>
	</form>
	</div>
</div>
<script type="text/javascript">
function checkInsert(form) {
	var r = form;
    if (form.id.value === '' || form.pwd.value === '' || form.name.value === '' || form.email.value === '') {
        alert("��ĭ�� �ֽ��ϴ�. ��� �Է����ּ���.");
        return false;
    }
    return true;
}
</script>
</body>
</html>



