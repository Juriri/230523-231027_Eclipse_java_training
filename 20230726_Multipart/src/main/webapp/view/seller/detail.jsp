<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function a() {
	var flag = confirm("���� �����Ͻðڽ��ϱ�?");
	if(flag){
		document.f.action="${pageContext.request.contextPath}/seller/Del?num=${product.num}";
		document.f.submit();
	} else {
		alert("��� �Ǿ����ϴ�. ");
	}
}
</script>
</head>
<body>
<form name="f" action="${pageContext.request.contextPath }/seller/Edit" method="post">
	<table border="1">
		<tr>
			<th>��ǰ��</th>
			<td>
			<input type="text" name="name" value="${product.name }">
			<input type="hidden" name="num" value="${product.num }">
			</td>
		</tr>
		<tr>
			<th>����</th>
			<td>
			<input type="text" name="quantity" value="${product.quantity }">
			</td>
		</tr>
		<tr>
			<th>����</th>
			<td>
			<input type="text" name="price" value="${product.price }">
			</td>
		</tr>
		<tr>
			<th>��ǰ �̹���</th>
			<%-- <td>${product.img }<br><img src="${product.img }" width="300" height="300"></td> --%>
			<td>
	        	<c:choose>
	            <c:when test="${product.img == '/shop_img/null'}">
	                <img src="https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg" width="300" height="300">
	            </c:when>
	            
	            <c:otherwise>
	            ${product.img}<br>
	           	<img src="${product.img}" width="300" height="300">
	            </c:otherwise>
	        	</c:choose>
    		</td>
		</tr>
		<tr>
			<th>�� ����</th>
			<td>
			<input type="text" name="content" value="${product.content }">
			</td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="����">
		<input type="button" value="����" onclick="a()"></td>
		</tr>
	</table>
</form>
</body>
</html>