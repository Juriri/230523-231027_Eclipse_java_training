<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="model.*"%>  
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Insert title here</title>
</head>
<body>
    <% ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("data"); %>
    <table border="1">
        <tr>
            <th>Num</th>
            <th>Id</th>
            <th>Pwd</th>
            <th>Email</th>
            <th>동작</th>
        </tr>
        <% for (int i = 0; i < list.size(); i++) {
            Member member = list.get(i);
        %>
        <tr>
            <td><%= member.getNum() %></td>
            <td><%= member.getId() %></td>
            <td><%= member.getPwd() %></td>
            <td><%= member.getEmail() %></td>
            <td>
                <form action="<%=request.getContextPath()%>/control" method="post">
        			<input type="hidden" name="type" value="delete">
        			<input type="hidden" name="num"  value="<%= member.getNum() %>">
        			<input type="submit" value="삭제">
   		 		</form>
   		 		<form action="<%=request.getContextPath()%>/control" method="post">
        			<input type="hidden" name="type" value="update">
        			<input type="hidden" name="num"  value="<%= member.getNum() %>">
        			<input type="submit" value="수정">
   		 		</form>
            </td>
        </tr>
        <% } %>
        
    </table>
</body>
</html>