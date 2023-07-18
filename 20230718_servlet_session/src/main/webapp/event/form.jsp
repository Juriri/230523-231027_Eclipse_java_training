<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ���</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
	<h3>ȸ���� ����ϼ���.</h3>
		<div class="row">
			<div class="col-md-6">
		    	<form action="<%=request.getContextPath()%>/control" method="post">
		        <input type="hidden" name="type" value="insert">
		        <div class="mb-3">
		        	<label for="id" class="form-label">ID:</label>
                   	<input type="text" class="form-control" id="id" name="id">
			    </div>
			    <div class="mb-3">
                   <label for="email" class="form-label">Email:</label>
                   <input type="text" class="form-control" id="email" name="email">
                </div>
                <div class="mb-3">
                   <label for="pwd" class="form-label">Password:</label>
                   <input type="password" class="form-control" id="pwd" name="pwd">
                </div>
             	<button type="submit" class="btn btn-primary">�̺�Ʈ ���</button>   
		    	</form>
		    </div>
		    
		    <div class="col-md-6">
		        <form action="<%=request.getContextPath()%>/control" method="post">
                    <input type="hidden" name="type" value="list">
                    <button type="submit" class="btn btn-info">����� ��� ����</button>
                </form>
                <form action="<%=request.getContextPath()%>/user_control" method="get">
                    <input type="hidden" name="type" value="signin">
                    <button type="submit" class="btn btn-success">�α���</button>
                </form>
                <form action="<%=request.getContextPath()%>/user_control" method="post">
                    <input type="hidden" name="type" value="signout">
                    <button type="submit" class="btn btn-danger">�α׾ƿ�</button>
                </form>
                 ${alertScript}
		    </div>
	    </div>
    </div>
   
    <!-- Bootstrap JS �ε� -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

