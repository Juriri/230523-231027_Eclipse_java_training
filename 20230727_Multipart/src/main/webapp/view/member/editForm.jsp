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
	<h3>������ ����</h3>
	<c:if test="${not empty sessionScope.member}">
	<form action="${pageContext.request.contextPath}/EditController" method="post">
		id: ${member.getId()} <br>
		<input type="hidden" name="id" value="${member.getId()}">
		<input type="hidden" name="type" value="${member.getType()}">
		������ �н�����: <input type="text" name="pwd" value="${member.getPwd()}"><br>
		������ �̸�: <input type="text" name="name" value="${member.getName()}"><br>
		������ �̸���: <input type="text" name="email" value="${member.getEmail()}"><br>
		������ �ּ�: <input type="text" name="addr" value="${member.getAddr()}"><br>
		<input type="submit" value="ȸ�� ���� ����">
	</form>
	<a href="${pageContext.request.contextPath }/view/member/result.jsp">Ȩȭ��</a>
	</c:if>
	
	<c:if test="${empty sessionScope.member}">
	�α��� ������ �����ϴ�. �α��� ���� ���ּ��� <br>
	<a href="${pageContext.request.contextPath }/view/member/loginForm.jsp">�α����ϱ�</a>
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