<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="model.*"%>  
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>ȸ�� ����Ʈ ����մϴ�. </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>

</style>
<body>
<div class="container mt-4">
	<div class="row">
	<h3>ȸ�� ����Ʈ</h3>
    <%List<Member> list = (ArrayList<Member>) request.getAttribute("data"); %>
	    <table border="1" class="table">
	        <tr>
	            <th>����</th>
	            <th>ID</th>
	            <th>PWD</th>
	            <th>Email</th>
	            <th>����</th>
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
	        			<input type="submit" class="btn btn-danger" value="����">
	   		 		</form>
	   		 		<form action="<%=request.getContextPath()%>/control" method="post">
	        			<input type="hidden" name="type" value="update">
	        			<input type="hidden" name="num"  value="<%= member.getNum() %>">
	        			<input type="submit" class="btn btn-success" value="����">
	   		 		</form>
	           </td>
	        </tr>
	        <% } %>
	        
	    </table>
    </div>
</div>
</body>
=======
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="model.*"%>  
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>ȸ�� ����Ʈ ����մϴ�. </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>

</style>
<body>
<div class="container mt-4">
	<div class="row">
	<h3>ȸ�� ����Ʈ</h3>
    <%List<Member> list = (ArrayList<Member>) request.getAttribute("data"); %>
	    <table border="1" class="table">
	        <tr>
	            <th>����</th>
	            <th>ID</th>
	            <th>PWD</th>
	            <th>Email</th>
	            <th>����</th>
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
	        			<input type="submit" class="btn btn-danger" value="����">
	   		 		</form>
	   		 		<form action="<%=request.getContextPath()%>/control" method="post">
	        			<input type="hidden" name="type" value="update">
	        			<input type="hidden" name="num"  value="<%= member.getNum() %>">
	        			<input type="submit" class="btn btn-success" value="����">
	   		 		</form>
	           </td>
	        </tr>
	        <% } %>
	        
	    </table>
    </div>
</div>
</body>
>>>>>>> refs/remotes/origin/main
</html>