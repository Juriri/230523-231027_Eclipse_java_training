<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="msg" value="${requestScope.msg }"/>
    <c:if test="${not empty msg}">
        <p>${msg}</p>
    </c:if>
    
<a href="${pageContext.request.contextPath}/home.jsp">홈 화면 이동</a>
</body>
</html>