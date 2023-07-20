<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.Member" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
int x= 10;
Map<String, String> map = new HashMap<String, String>();
	map.put("name", "aaa");
	map.put("tel", "111");
	map.put("address", "대한민국");

	//Member에 객채를 생성한다.
	Member member = new Member("bbb", "1234", "hong", "bbb@email.com");
%>
x를 pageContext에 x 이름으로 저장후 출력<br>
<c:set var="x" value="<%=x%>" />
x : ${x }	
<br>

map객체를 pageContext에 map1이름으로 저장후 출력<br>
<c:set var="map1" value="<%=map%>" />
map1=> name: ${map1.name }, tel:${map1.tel }, address:${map1.address }	
<br>

객체 member의 id의 ccc, name을 수정한 뒤 출력<br>
<c:set target="<%=member %>" property="id" value="ccc" />
<c:set target="<%=member %>" property="name" value="장동건" />
<c:set var="m1" value="<%=member %>" />
member=> id:${m1.id }, pwd:${m1.password }, name: ${m1.name }, email: ${m1.email }
<br>
<c:set var="y" scope="page">page</c:set>
<c:set var="y" scope="request">request</c:set>
<c:set var="y" scope="session">session</c:set>
<c:set var="y" scope="application">application</c:set>

<br>request의 y 삭제 전 <br>
${pageScope.y }<br>
${requestScope.y }<br>
${sessionScope.y }<br>
${applicationScope.y }<br>
<c:remove var="y" scope="request" />

<br>request의 y 삭제 후 <br>
${pageScope.y }<br>
${requestScope.y }<br>
${sessionScope.y }<br>
${applicationScope.y }<br>
<br>
</body>
</html>