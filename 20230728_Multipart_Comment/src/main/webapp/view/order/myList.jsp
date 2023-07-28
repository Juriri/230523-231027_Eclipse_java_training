<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="container">
	<c:if test="${o_state==0 }">
	<h3>주문 목록</h3>
	</c:if>
	
	<c:if test="${o_state==1 }">
	<h3>장바구니 목록</h3>
	<table border="1">
		<tr>
			<th>주문번호</th>
			<th>제품명</th>
			<th>사진</th>
			<th>주문수량</th>
			<th>결제금액</th>
			<th>주문일</th>
		</tr>
		<c:forEach var="o" items="${list }">
			<tr>
				<td>${o.num }</td>
				<td>
				<a href="${pagecontext.request.contextPath }/seller/detail?num=${o.pro_num}">${o.prod_name }</a>
				</td>
				<td>
				<img src="${o.prod_img }" width="200" height="200">
				</td>
				<td>
				${o.order_num }
				</td>
				<td>
				${o.total_price }
				</td>
				<td>
				${o.o_date }
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</div>

</body>
</html>