<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>검색 합니다.  </h3>
<form action="<%=request.getContextPath()%>/control?type=search" method="post" name="productForm">
<table>
<tr>
	<td>이름 : <input type="text" name="pd_name"></td>
</tr>
</table>
<input type="button" onClick="checkName(this.form)" value="검색">
</form>


<h3>멤버 검색결과 출력</h3>
<table>
<thead>
	<tr>
	<th>순번</th>
	<th>이름</th>
	<th>전화번호</th>
	<th>주소</th>
	<th>우편번호</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${member_result_list}" var="member">
	<tr>
	<td>
    <a href="<%=request.getContextPath()%>/control?type=update&num=${member.getNum()}">${member.getNum()}</a>
    </td>
	<td>${member.getName()}</td>
	<td>${member.getTel()}</td>
	<td>${member.getAddress()}</td>
	<td>${member.getPostal()}</td>
	</tr>
	</c:forEach>
</tbody>

</table>

<script>
function checkName(form) {
	var r = form;
	if(r.pd_name.value ===''){
		alert("빈칸이 있습니다. 입력해주세요.");
		return false;
	}
	
	r.submit();
}
</script>
</body>
=======
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>검색 합니다.  </h3>
<form action="<%=request.getContextPath()%>/control?type=search" method="post" name="productForm">
<table>
<tr>
	<td>이름 : <input type="text" name="pd_name"></td>
</tr>
</table>
<input type="button" onClick="checkName(this.form)" value="검색">
</form>


<h3>멤버 검색결과 출력</h3>
<table>
<thead>
	<tr>
	<th>순번</th>
	<th>이름</th>
	<th>전화번호</th>
	<th>주소</th>
	<th>우편번호</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${member_result_list}" var="member">
	<tr>
	<td>
    <a href="<%=request.getContextPath()%>/control?type=update&num=${member.getNum()}">${member.getNum()}</a>
    </td>
	<td>${member.getName()}</td>
	<td>${member.getTel()}</td>
	<td>${member.getAddress()}</td>
	<td>${member.getPostal()}</td>
	</tr>
	</c:forEach>
</tbody>

</table>

<script>
function checkName(form) {
	var r = form;
	if(r.pd_name.value ===''){
		alert("빈칸이 있습니다. 입력해주세요.");
		return false;
	}
	
	r.submit();
}
</script>
</body>
>>>>>>> refs/remotes/origin/main
</html>