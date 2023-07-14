<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name=x 
action="<%=request.getContextPath()%>/control?type=insert" method="post">
<table>
<tr>
	<th></th>
</tr>

<tr>
<td>저자: <input type="text" name="author"><br><br></td>
</tr>
<tr>
<td>제목: <input type="text" name="title"><br><br></td>
</tr>
<tr>
<td>출판사: <input type="text" name="publisher"><br><br></td>
</tr>
<tr>
<td>컨텐츠: <input type="text" name="content"><br><br></td>
</tr>
</table>
<input type="submit" value="도서 입력">
</form>
</body>
</html>