<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Comment"%>
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
        
        function addComment() {
            var commentText = document.getElementsByName("commentText")[0].value;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "${pageContext.request.contextPath}/order/CommentController?action=add", true);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var comments = JSON.parse(xhr.responseText);
                    var commentContainer = document.getElementById("commentContainer");
                    commentContainer.innerHTML = ''; // 기존 댓글 목록을 비우고 다시 표시
                    comments.forEach(function (comment) {
                        var p = document.createElement("p");
                        p.textContent = comment.user_id + ": " + comment.user_comment;
                        commentContainer.appendChild(p);
                    });
                }
            };
            xhr.send("productId=${product.num}&userId=${sessionScope.member.getId()}&commentText=" + encodeURIComponent(commentText));
            // 댓글 추가 후 입력 필드 초기화
            document.getElementsByName("commentText")[0].value = '';
        }
        
        function getComments() {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "${pageContext.request.contextPath}/order/CommentController?action=getComments&productId=${product.num}", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                	var comments = JSON.parse(xhr.responseText);
                    // 댓글 목록을 동적으로 표시하는 로직을 구현합니다.
                    // 이 예시에서는 comments 배열을 순회하며 댓글을 표시합니다.
                    var commentContainer = document.getElementById("commentContainer");
                    commentContainer.innerHTML = ''; // 기존 댓글 목록을 비우고 다시 표시
                    comments.forEach(function (comment) {
                        var p = document.createElement("p");
                        p.textContent = comment.user_id + ": " + comment.user_comment;
                        commentContainer.appendChild(p);
                    });
                }
            };
            xhr.send();
        }
        // 페이지 로드 시 댓글 목록을 받아오기 위해 호출합니다.
        getComments();
     	// 60초마다 댓글 목록을 갱신하기 위해 setInterval() 함수를 사용합니다.
        setInterval(getComments, 60000); // 60초(60000ms) 마다 호출
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
                                <%-- <img src="${product.img}" alt="Product Image"> --%>
                                <img src="${pageContext.request.contextPath}${product.img}" width="300" height="300">
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
	    	<form name="commentForm">
		        <input type="hidden" name="productId" value="${product.num}">
		        <input type="hidden" name="userId" value="${sessionScope.member.getId() }">
		        ${sessionScope.member.getId() }<br>
		        <textarea name="commentText" rows="4" cols="50"></textarea><br>
		        <input type="button" value="댓글 작성" onclick="addComment()">
	   		</form>
		</div>
    	<div id="commentContainer">
   		</div>
    </c:otherwise>
</c:choose>
</body>
</html>