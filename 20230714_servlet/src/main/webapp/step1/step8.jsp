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
	ServletContext context=getServletContext();
	context.setAttribute("m", m);
}
%>
<h3>JSPInit 메서드에서 생성한 객체</h3>
<%
member m = (member)application.getAttribute("m");
out.print("id: "+m.getId()+"<br>");
out.print("pwd: "+m.getPwd()+"<br>");
out.print("name: "+m.getName()+"<br>");
out.print("email: "+m.getEmail()+"<br>");
%>
</body>
</html>