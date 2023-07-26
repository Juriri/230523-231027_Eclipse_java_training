<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
    <style>
        /* Style the anchor tag as a button */
        .button-link {
            display: inline-block;
            padding: 8px 12px;
            background-color: #007BFF; /* Button background color */
            color: #FFF; /* Button text color */
            text-decoration: none;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        /* Change link appearance when hovered */
        .button-link:hover {
            background-color: #0056b3; /* Hover background color */
        }
    </style>
</head>
<body>
<h3>���� ����� ��ǰ</h3>
<a href="${pageContext.request.contextPath }/seller/AddForm">�� ��ǰ ���</a>
<c:if test = "${not empty list }">
	<table border="1">
		<tr>
			<th>�� ��ȣ</th>
			<th>��ǰ��</th>
			<th>����</th>
		</tr>
			
		<c:forEach var="product" items="${list}">
		<tr>
			<td>${product.getNum()}</<td>
			<td>
			<a href="${pageContext.request.contextPath }/seller/detail?num=${product.getNum()}">${product.getName()}</a>
			</td>
			<td>
			<%-- <a href="${pageContext.request.contextPath }/seller/Del?num=${product.getNum()}" onclick="return confirm('���� �����Ͻðڽ��ϱ�?');">����</a> --%>
			<a class="button-link" href="${pageContext.request.contextPath }/seller/Del?num=${product.getNum()}" onclick="return confirm('���� �����Ͻðڽ��ϱ�?');">����</a>
			</td>
		</tr>	
		</c:forEach>
	</table>
</c:if>
	
<c:if test = "${empty list }">
��ǰ ����� �����ϴ�. 
</c:if>
</body>
</html>