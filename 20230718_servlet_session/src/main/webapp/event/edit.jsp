<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <% Member member = (Member) request.getAttribute("data"); %>
    <form action="<%=request.getContextPath()%>/control" method="post">
        <input type="hidden" name="type" value="update.do">
        <input type="hidden" name="num" value="<%= member.getNum() %>">
        Num: <p><%= member.getNum()%></p>
        email: <input type="text" name="email"><br>
        pwd: <input type="password" name="pwd"><br>
        <input type="submit" value="수정"><br>
    </form>
</body>
</html>




