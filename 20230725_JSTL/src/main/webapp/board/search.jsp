<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board_style.css">
</head>
<body>
	<h3>��ȸ ���</h3>
	<br>
	<c:if test = "${not empty board and sessionScope.member.getId() == board.getWriter()}">
		<form action="${pageContext.request.contextPath }/EditBoardController" method="post">
			<table border="1">
				<tr>
					<th>�� ��ȣ</th>
					<th>�ۼ���</th>
					<th>�ۼ���</th>
					<th>����</th>
					<th>����</th>
				</tr>
				<tr>
					<td>${board.getNum()}</td>
					<td>${board.getWriter()}</td>
					<td>${board.getW_date()}</td>
					<td>${board.getTitle()}</td>
					<td>${board.getContent()}</td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="num" value="${board.getNum() }"><br>
			������ ����: <input type="text" name="title"><br>
			������ ����: <input type="text" name="content"><br>
			<input type="submit" value="�Խñ� ����">
		</form>
	</c:if>
	
	<c:if test = "${empty board}">
		��ȸ ����� �����ϴ�.
	</c:if>
	<c:if test = "${sessionScope.member.getId() != board.getWriter()}">
		�ۼ��ڰ� �ƴϹǷ� �ش� ������ �����ϴ�.
	</c:if>		
</body>
</html>