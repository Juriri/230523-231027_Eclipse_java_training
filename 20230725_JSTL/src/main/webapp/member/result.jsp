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
		<h3>�޴�</h3>
		<c:if test = "${not empty sessionScope.member }">
			${sessionScope.member.getId() }�� �α���<br>
			${sessionScope.member.getName() }�� ȯ���մϴ�. !<br><br>
			<a href= "${pageContext.request.contextPath}/SearchController">�� ���� ����</a><br>
			<a href= "${pageContext.request.contextPath}/LogoutController">�α׾ƿ�</a><br>
			<a href= "${pageContext.request.contextPath}/DelController">ȸ�� Ż��</a><br>
			<a href= "${pageContext.request.contextPath}/WriteController">�Խñ� �ۼ�</a><br>
			<a href= "${pageContext.request.contextPath}/ListController">�Խñ� ����</a><br>
		</c:if>
		
		<c:if test = "${empty sessionScope.member }">
		<h3>�α��� ����</h3>
		<a href="${pageContext.request.contextPath}/member/loginForm.jsp">�α��� ������ �̵�</a>
		</c:if>
	</div>
</div>
</body>
</html>