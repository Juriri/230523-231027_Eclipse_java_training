<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
	<h3>제품 목록(구매자 화면)</h3>
	<a href="${pageContext.request.contextPath}/view/member/result.jsp">홈 화면</a><br>
	<br>
	<c:choose>
		<c:when test="${empty sessionScope.member}">
	        잘못된 접근입니다. 로그인 해주세요.<br>
	   		<a href="${pageContext.request.contextPath}/view/member/loginForm.jsp">로그인 이동</a>
	    </c:when>
	    
	    <c:when test="${empty list}">
	        상품이 없습니다.<br>
	    </c:when>
	    
	    <c:otherwise>
			<table border="1">
				<tr>
					<th>제품 번호</th>
					<th>판매자</th>
					<th>제품 사진</th>
					<th>제품 이름</th>
					<th>제품 수량</th>
					<th>제품 가격</th>
					<th>삭제/수정</th>
				</tr>
				
				<c:forEach var="product" items="${list}">
				<tr>
					<td>
					<a href="${pageContext.request.contextPath }/seller/detail?num=${product.getNum()}&type=customer">${product.getNum()}</a>
					</td>
					
					<td>${product.getS_id()}</td>				                   
                    <td>
                        <c:choose>
                            <c:when test="${product.img == '/shop_img/null'}">
                                <img src="https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg" width="110" height="70">
                            </c:when>
                            <c:otherwise>
                                <img src="${product.img}" width="110" height="70">
                                <%-- <img src="${pageContext.request.contextPath}${product.img}" width="110" height="70"> --%>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    
                    
					<td>${product.getName()}</td>
					<td>${product.getQuantity()}</td>
					<td>${product.getPrice()}</td>
					<td>
						<form action="${pageContext.request.contextPath}/order/Del?num=${product.getNum()}" method="post">
							<input type="submit" name="cart" value="구매">
						</form>
					</td>
				</tr>
			
				</c:forEach>
			</table>
	    </c:otherwise>
	</c:choose>
	
</body>
</html>