<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board_style.css">
</head>
<body>
	<h3>���ۼ�</h3>
	<form action="${pageContext.request.contextPath }/WriteController" method="post">
		<table border="1" cellspacing="0">
			<tr>
			<th>�ۼ���: </th>
			<td>${sessionScope.member.getId()}</td>
			<input type="hidden" name="writer" value="${sessionScope.member.getId()}">
			</tr>
			
			<tr>
			<th>�� ����: </th>
			<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
			<th>�� ����: </th>
			
			<td>
    		<textarea name="content" rows="4" cols="50"></textarea>
			</td>
			</tr>
		</table>
		<td><button type="submit" value="�� ���">�� ���</button></td>
		<td><button type="reset" value="���">���</button></td>
	</form>
</body>
</html>