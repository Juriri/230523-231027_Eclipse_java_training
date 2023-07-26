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
</head>
<body>
	<h3>�� ���</h3>
	<a href="${pageContext.request.contextPath}/board/form.jsp">�� �ۼ�</a>
	<br>
	<c:if test = "${not empty list }">
		<table border="1">
			<tr>
				<th>�� ��ȣ</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>����</th>
				<th>����/����</th>
			</tr>
			
			<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.getNum()}</<td>
				<td>${board.getWriter()}</td>
				<td>${board.getW_date()}</td>
				<td>
				<a href="${pageContext.request.contextPath }/ReadController?num=${board.getNum()}">${board.getTitle()}</a>
				</td>
				<td>
				<form action="${pageContext.request.contextPath}/DelBoardController?type=update&num=${board.getNum()}" method="post">
					<input type="hidden" value="${board.getNum() }">
					<input type="submit" name="update" value="����">
				</form>
				<form action="${pageContext.request.contextPath}/DelBoardController?type=delete&num=${board.getNum()}" method="post">
					<input type="hidden" value="${board.getNum() }">
					<input type="submit" name="delete" value="����">
				</form>
				</td>
			</tr>
		
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test = "${empty list }">
		�ۼ��� ���� �����ϴ�. 
	</c:if>
</body>
</html>