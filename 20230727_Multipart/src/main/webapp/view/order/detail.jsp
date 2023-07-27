<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/order_style.css">
    <script type="text/javascript">
        function BuyProduct() {
            var flag = confirm("장바구니에 담을까요?");
            if (flag) {
                document.buyForm.action = "${pageContext.request.contextPath}/order/Del?num=${product.num}";
                document.buyForm.submit();
            } else {
                alert("취소 되었습니다. ");
            }
        }		
    </script>
</head>
<body>
<h3>제품 구매창</h3>
<c:choose>
    <c:when test="${empty sessionScope.member}">
        <p style="text-align: center; font-size: 18px;">잘못된 접근입니다. 로그인 해주세요.</p>
        <p style="text-align: center;"><a href="${pageContext.request.contextPath}/view/member/loginForm.jsp">로그인 이동</a></p>
    </c:when>
    <c:when test="${empty product}">
        <p style="text-align: center; font-size: 18px;">잘못된 접근입니다. 홈으로 돌아가세요.</p>
        <p style="text-align: center;"><a href="${pageContext.request.contextPath}/view/member/result.jsp">홈 이동</a></p>
    </c:when>
    <c:otherwise>
    <p style="text-align: center; margin-top: 20px;"><a href="${pageContext.request.contextPath}/order/list">목록 이동</a></p>
        <form name="buyForm" class="buyForm" action="${pageContext.request.contextPath}/seller/Edit" method="post">
            <table>
                <tr>
                    <th>판매자</th>
                    <td>
                        <input type="hidden" name="num" value="${product.num}">
                        <input type="text" name="s_id" value="${product.s_id}" readonly>
                    </td>
                </tr>
                <tr>
                    <th>상품명</th>
                    <td>
                        <input type="text" name="name" value="${product.name}" readonly>
                    </td>
                </tr>
                <tr>
                    <th>재고</th>
                    <td>
                        <input type="text" name="quantity" value="${product.quantity}" readonly>
                    </td>
                </tr>
                <tr>
                    <th>가격</th>
                    <td>
                        <input type="text" name="price" value="${product.price}" readonly>
                    </td>
                </tr>
                <tr>
                    <th>상품 이미지</th>
                    <td>
                        <c:choose>
                            <c:when test="${product.img == '/shop_img/null'}">
                                <img src="https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg" alt="No Image">
                            </c:when>
                            <c:otherwise>
                                <img src="${product.img}" alt="Product Image">
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>상세 설명</th>
                    <td>
                        <textarea name="content" readonly>${product.content}</textarea>
                    </td>
                </tr>
            </table>
            <div class="button-container">
                <button type="button" onclick="BuyProduct()">장바구니</button>
            </div>
        </form>
        <div class="comment-form">
	        <h4>댓글 작성</h4>
	    	<form name="commentForm" action="${pageContext.request.contextPath}/order/CommentController?action=add" method="post">
		        <input type="hidden" name="productId" value="${product.num}">
		        <input type="hidden" name="userId" value="${sessionScope.member.getId() }">
		        ${sessionScope.member.getId() }<br>
		        <textarea name="commentText" rows="4" cols="50"></textarea><br>
		        <input type="submit" value="댓글 작성">
	   		 </form>
		</div>
    	
    	<h4>댓글 목록</h4>
    	<c:forEach items="${comments}" var="comment">
        	<p>${comment.user}: ${comment.text}</p>
    	</c:forEach>
    	
    </c:otherwise>
</c:choose>
</body>
</html>