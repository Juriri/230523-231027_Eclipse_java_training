<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.MemberVO, java.util.HashMap, java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%MemberVO vo1 = new MemberVO("java", "abcd", "������", "�Ǳ�");
session.setAttribute("mvo", vo1);

String name[] = {"Ȳ����","��ڻ�","������"};
session.setAttribute("name",name);

Map map = new HashMap();
map.put("mem1",vo1);
MemberVO vo2 = new MemberVO("JSP","1234","������","����");
map.put("mem2", vo2);
session.setAttribute("memMap", map);
%>

EL ù��° ����<br>
<a href="step2.jsp">step2���� eló�� Ȯ���ϱ�</a>
</body>
</html>