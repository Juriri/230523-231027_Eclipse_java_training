<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.memberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
memberVO vo = new memberVO("java", "1234", "아이유", "판교");

%>

<% if(vo.getId().equals("java")  && vo.getPassword().equals("1234")) {%>
회원아이디: <%=vo.getId() %>
회원비밀번호: <%=vo.getPassword() %>
회원 이름: <%=vo.getName() %>
회원 주소 : <%=vo.getAddress() %>

<% } %>


</body>
</html>