<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>HELLO JSP</h3>
<!--  JSP �ּ� -->

<%
int i;for(i=1; i<6; i++) {
%>

<h <%=i %>>hello</h<%=i%>>
<% } %>
</body>
</html>