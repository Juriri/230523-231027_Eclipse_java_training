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
	<h3>글 목록</h3>
	<a href="${pageContext.request.contextPath}/board/form.jsp">글 작성</a>
	<br>
	<c:if test = "${not empty list }">
		<table border="1">
			<tr>
				<th>글 번호</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>제목</th>
				<th>삭제/수정</th>
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
					<input type="submit" name="update" value="수정">
				</form>
				<form action="${pageContext.request.contextPath}/DelBoardController?type=delete&num=${board.getNum()}" method="post">
					<input type="hidden" value="${board.getNum() }">
					<input type="submit" name="delete" value="삭제">
				</form>
				</td>
			</tr>
		
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test = "${empty list }">
		작성된 글이 없습니다. 
	</c:if>
</body>
</html>