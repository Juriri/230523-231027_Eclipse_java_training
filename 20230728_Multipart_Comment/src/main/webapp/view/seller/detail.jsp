<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/seller_style.css">
    <script type="text/javascript">
    	/* 작성자 != 판매자로 삭제와 삭제 권한이 없을 때 alert 출력 */
	    var resultMsg = '<%= request.getAttribute("msg") %>';
		if (resultMsg != "null" && resultMsg.trim() !== '') {
		    alert(resultMsg);
		}
	
        function deleteProduct() {
            var flag = confirm("정말 삭제하시겠습니까?");
            if (flag) {
                document.editForm.action = "${pageContext.request.contextPath}/seller/Del?num=${product.num}";
                document.editForm.submit();
            } else {
                alert("취소 되었습니다. ");
            }
        }
               
        function getComments() {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "${pageContext.request.contextPath}/comment/CommentController?action=getComments&productId=${product.num}", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                	var comments = JSON.parse(xhr.responseText);
                    // 댓글 목록을 동적으로 표시하는 로직을 구현합니다.
                    // 이 예시에서는 comments 배열을 순회하며 댓글을 표시합니다.
                    console.log(comments);
                    var commentContainer = document.getElementById("commentContainer");
                    commentContainer.innerHTML = ''; // 기존 댓글 목록을 비우고 다시 표시
                    
                    if(comments.length === 0){
                    	var p = document.createElement("p");
                        p.textContent = "댓글 없음";
                        commentContainer.appendChild(p);
                    } else{
                    	//댓글 관리
                    	comments.forEach(function (comment) {
                            var p = document.createElement("p");
                            p.textContent = comment.user_id + ": " + comment.user_comment;
                         	
                            // 삭제 버튼 생성 및 이벤트 처리
                            var deleteButton = document.createElement("button");
                            deleteButton.textContent = "삭제";
                            deleteButton.onclick = function () {
                                deleteComment(comment.comment_num, comment.user_id);
                            };
                            p.appendChild(deleteButton);
                            
                            commentContainer.appendChild(p);
                        });
                    }
                }
            };
            xhr.send();
        }
        
        function deleteComment(commentId, userId) {
            // Send a DELETE request to the server to delete the comment
            var xhr = new XMLHttpRequest();
            xhr.open("DELETE", "${pageContext.request.contextPath}/comment/CommentController?action=deleteComment&userId="+userId+"&commentId=" + commentId, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        // Comment deleted successfully, update the comments
                        getComments();
                    } else {
                        // Handle error, if any
                       	alert("Error deleting comment");
                    }
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
<h3>제품 판매창</h3>
<a href="${pageContext.request.contextPath}/seller/List">목록 이동</a>
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
                                <%-- <img src="${pageContext.request.contextPath}${product.img}" width="300" height="300"> --%>
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
        
        <div id="commentContainer">
   		</div>
    </c:otherwise>
</c:choose>

</body>
</html>