<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("pageScope","page data");
request.setAttribute("requestScope","request data");
session.setAttribute("sessionScope","session data");
application.setAttribute("applicationScope","application data");

/* String myPage=(String)pageContext.getAttribute("pageScope");
String myRequest = (String)request.getAttribute("requestScope");
String mySession = (String)session.getAttribute("sessionScope");
String myApplication = (String)application.getAttribute("applicationScope"); */

pageContext.forward("scopeTest2.jsp");


%>
</body>
</html>