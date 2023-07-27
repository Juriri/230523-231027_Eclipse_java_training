<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/seller_style.css">
    <script type="text/javascript">
        function deleteProduct() {
            var flag = confirm("정말 삭제하시겠습니까?");
            if (flag) {
                document.editForm.action = "${pageContext.request.contextPath}/seller/Del?num=${product.num}";
                document.editForm.submit();
            } else {
                alert("취소 되었습니다. ");
            }
        }
        
        var resultMsg = '<%= request.getAttribute("msg") %>';
		if (resultMsg != "null" && resultMsg.trim() !== '') {
		    alert(resultMsg);
		}
		
    </script>
</head>
<body>
<h3>제품 판매창</h3>
<c:choose>
    <c:when test="${empty sessionScope.member}">
        잘못된 접근입니다. 로그인 해주세요.<br>
        <a href="${pageContext.request.contextPath}/view/member/loginForm.jsp">로그인 이동</a>
    </c:when>
    <c:when test="${empty product}">
        잘못된 접근입니다. 홈으로 돌아가세요.<br>
    </c:when>
    <c:otherwise>
        <form name="editForm" action="${pageContext.request.contextPath}/seller/Edit" method="post">
            <table border="1">
                <tr>
                    <th>판매자</th>
                    <td>
                        <input type="hidden" name="num" value="${product.num}">
                        <input type="text" name="s_id" value="${product.s_id}">
                    </td>
                </tr>
                <tr>
                    <th>상품명</th>
                    <td>
                        <input type="text" name="name" value="${product.name}">
                    </td>
                </tr>
                <tr>
                    <th>수량</th>
                    <td>
                        <input type="text" name="quantity" value="${product.quantity}">
                    </td>
                </tr>
                <tr>
                    <th>가격</th>
                    <td>
                        <input type="text" name="price" value="${product.price}">
                    </td>
                </tr>
                <tr>
                    <th>상품 이미지</th>
                    <td>
                        <c:choose>
                            <c:when test="${product.img == '/shop_img/null'}">
                                <img src="https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg" width="300" height="300">
                            </c:when>
                            <c:otherwise>
                                <%-- ${product.img}<br> --%>
                                <img src="${product.img}" width="300" height="300">
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>상세 설명</th>
                    <td>
                        <input type="text" name="content" value="${product.content}">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="수정">
                        <input type="button" value="삭제" onclick="deleteProduct()">
                    </td>
                </tr>
            </table>
        </form>
    </c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/seller/List">목록 이동</a>

</body>
</html>