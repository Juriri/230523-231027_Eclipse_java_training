<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>모든 멤버 정보 출력</h3>
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
	<c:forEach items="${member_list}" var="member">
	<tr>
	<td>${member.getNum()}</td>
	<td>${member.getName()}</td>
	<td>${member.getTel()}</td>
	<td>${member.getAddress()}</td>
	<td>${member.getPostal()}</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>