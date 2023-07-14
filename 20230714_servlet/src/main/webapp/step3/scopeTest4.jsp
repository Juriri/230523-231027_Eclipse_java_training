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
String myPage=(String)pageContext.getAttribute("pageScope");
String myRequest = (String)request.getAttribute("requestScope");
String mySession = (String)session.getAttribute("sessionScope");
String myApplication = (String)application.getAttribute("applicationScope");
%>

pageScope=<%=myPage %>
requestScope=<%=myRequest %>
sessionScope=<%=mySession %>
applicationScope=<%=myApplication %>

<a href="scopeTest5.jsp">다음 페이지로 이동</a>
</body>
</html>