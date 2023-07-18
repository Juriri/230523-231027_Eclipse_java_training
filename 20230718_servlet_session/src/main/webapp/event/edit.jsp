<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 정보 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
	<h3>회원 정보 수정</h3>
  	<% Member member = (Member)request.getAttribute("data"); %>
  		<div class="row">
		    <form action="<%=request.getContextPath()%>/control" method="post">
		        <input type="hidden" name="type" value="update.do">
		        <div class="mb-3">
		        	 <label for="num" class="form-label">Num: </label>
		       		 <input type="hidden" class="form-control" name="num" value="<%=member.getNum()%>">
		       		 <span name="num"><%=member.getNum()%></span>
		        </div>
		       <div class="mb-3">
		        	 <label for="id" class="form-label">Id: </label>
		       		 <span name="id"><%=member.getId()%></span>
		        </div>
		        <div class="mb-3">
		        	<label for="email" class="form-label">Email</label>
		        	<input type="text" class="form-control" id="email" name="email">
		        </div>
		        <div class="mb-3">
		        	<label for="password" class="form-label">Password</label>
		        	<input type="password" class="form-control" id="pwd" name="pwd">
		        </div>
		        <button type="submit" class="btn btn-primary">수정</button>
		    </form>
		</div>
    </div>
</body>
</html>




=======
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




>>>>>>> refs/remotes/origin/main
