<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
	<h3>�α��� �������Դϴ�. </h3>
	<div class="row">
		<form action="<%=request.getContextPath()%>/user_control"  method="post">
		<input type="hidden" name="type" value="signin.do">
		<div class="mb-3">
		   <label for="id" class="form-label">ID:</label>
           <input type="text" class="form-control" id="id" name="id">
		</div>
		<div class="mb-3">
		   <label for="password" class="form-label">PASSWORD:</label>
           <input type="password" class="form-control" id="pwd" name="pwd">
		</div>
		<input type="submit" class="btn btn-danger" value="�α���">
		</form>
	</div>
</div>

</body>
=======
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
	<h3>�α��� �������Դϴ�. </h3>
	<div class="row">
		<form action="<%=request.getContextPath()%>/user_control"  method="post">
		<input type="hidden" name="type" value="signin.do">
		<div class="mb-3">
		   <label for="id" class="form-label">ID:</label>
           <input type="text" class="form-control" id="id" name="id">
		</div>
		<div class="mb-3">
		   <label for="password" class="form-label">PASSWORD:</label>
           <input type="password" class="form-control" id="pwd" name="pwd">
		</div>
		<input type="submit" class="btn btn-danger" value="�α���">
		</form>
	</div>
</div>

</body>
>>>>>>> refs/remotes/origin/main
</html>