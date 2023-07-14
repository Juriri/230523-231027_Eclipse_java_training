<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
public void jspInit() {
	member m = new member("id", "pwd", "name", "email");
	ServletContext context= getServletContext();
	context.setAttribute("m", m);
}%>
<%
	member m = (member) application.getAttribute("m");
%>
<form>
<table border="1">
<tr>
	<th>id</th>
	<td><input type="text" name="id" value="<%=m.getId()%>"></td>
</tr>
<tr>
	<th>name</th>
	<td><input type="text" name="name" value="<%=m.getName()%>"></td>
</tr>
<tr>
	<th>password</th>
	<td><input type="text" name="password" value="<%=m.getPwd()%>"></td>
</tr>
<tr>
	<th>email</th>
	<td><input type="text" name="email" value="<%=m.getEmail()%>"></td>
</tr>
</table>
</form>
</body>
</html>