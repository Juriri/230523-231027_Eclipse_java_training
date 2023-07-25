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
	<h3>조회 결과</h3>
	<br>
	<c:if test = "${not empty board and sessionScope.member.getId() == board.getWriter()}">
		<form action="${pageContext.request.contextPath }/EditBoardController" method="post">
			<table border="1">
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>제목</th>
					<th>내용</th>
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
			수정할 제목: <input type="text" name="title"><br>
			수정할 내용: <input type="text" name="content"><br>
			<input type="submit" value="게시글 수정">
		</form>
	</c:if>
	
	<c:if test = "${empty board}">
		조회 결과가 없습니다.
	</c:if>
	<c:if test = "${sessionScope.member.getId() != board.getWriter()}">
		작성자가 아니므로 해당 권한이 없습니다.
	</c:if>		
</body>
</html>