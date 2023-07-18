<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>정보를 수정합니다. </h3>
<form action="<%=request.getContextPath()%>/control?type=update.do&num=${member.getNum()}" method="post" name="productForm">
<table>
<tr>
	<td>순번 : ${member.getNum()}</td>
</tr>

<tr>
	<td>이름 : ${member.getName()}</td>
</tr>

<tr>
	<td>전화번호 : <input type="text" name="pd_tel"></td>
</tr>

<tr>
	<td>주소 : <input type="text" name="pd_addr"></td>
</tr>

<tr>
	<td>우편번호: <input type="text" name="pd_postal"></td>
</tr>
</table>
<input type="button" onClick="checkInsert(this.form)" value="정보수정">
</form>
<script>
function checkInsert(form) {
	var r = form;
	if(r.pd_tel.value ===''|| r.pd_addr.value ===''|| r.pd_postal.value ==='' ){
		alert("빈칸이 있습니다. 모두 입력해주세요.");
		return false;
	}
	
	r.submit();
}
</script>
</body>
</html>