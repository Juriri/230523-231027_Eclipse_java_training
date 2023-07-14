<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/insert.jsp">상품등록</a><br>
<a href="<%=request.getContextPath()%>/control?type=list">전체상품 출력</a><br>
<a href="<%=request.getContextPath()%>/step4/find.jsp">검색 및 수정</a><br>
</body>
</html>