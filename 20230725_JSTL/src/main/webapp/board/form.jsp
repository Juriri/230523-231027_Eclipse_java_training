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
	<h3>글작성</h3>
	<form action="${pageContext.request.contextPath }/WriteController" method="post">
		<table border="1" cellspacing="0">
			<tr>
			<th>작성자: </th>
			<td>${sessionScope.member.getId()}</td>
			<input type="hidden" name="writer" value="${sessionScope.member.getId()}">
			</tr>
			
			<tr>
			<th>글 제목: </th>
			<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
			<th>글 내용: </th>
			
			<td>
    		<textarea name="content" rows="4" cols="50"></textarea>
			</td>
			</tr>
		</table>
		<td><button type="submit" value="글 등록">글 등록</button></td>
		<td><button type="reset" value="취소">취소</button></td>
	</form>
</body>
</html>