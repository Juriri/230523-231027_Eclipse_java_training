<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.MemberVO, java.util.HashMap, java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%MemberVO vo1 = new MemberVO("java", "abcd", "아이유", "판교");
session.setAttribute("mvo", vo1);

String name[] = {"황정민","백박사","이진우"};
session.setAttribute("name",name);

Map map = new HashMap();
map.put("mem1",vo1);
MemberVO vo2 = new MemberVO("JSP","1234","이진우","술집");
map.put("mem2", vo2);
session.setAttribute("memMap", map);
%>

EL 첫번째 예제<br>
<a href="step2.jsp">step2에서 el처리 확인하기</a>
</body>
</html>