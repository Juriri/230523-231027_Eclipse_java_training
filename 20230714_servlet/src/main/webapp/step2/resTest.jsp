<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>시작페이지</h3>

<%
request.setAttribute("age", 23);
response.sendRedirect("resTest2.jsp?name=Hong");
%>
</body>
</html>