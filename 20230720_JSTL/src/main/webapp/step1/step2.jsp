<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.MemberVO, java.util.HashMap, java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
1. scriptlet���� ȸ�� ���� ���<br>
<%
MemberVO vo =(MemberVO) session.getAttribute("mvo");
%>
���̵�: <%=vo.getId()%>
�̸�: <%=vo.getName()%>
�ּ�: <%=vo.getAddress()%>
<br>
<hr>
<br>2. el�� ȸ�� ������ ���<br>
���̵� : ${sessionScope.mvo.id}
�̸� : ${sessionScope.mvo.name}
�ּ� : ${sessionScope.mvo.address}
<hr>
<br>3. �迭
<%String[] name = (String[])session.getAttribute("name");%>
<%=name[0]%>,<%=name[1]%>,<%=name[2]%>
<hr>
<br>4. �迭 ��� el
${sessionScope.name[0]} ${sessionScope.name[1]} ${sessionScope.name[2]}

<%
Map map = (HashMap)session.getAttribute("memMap");
MemberVO vo1 = (MemberVO)map.get("mem1");
MemberVO vo2 = (MemberVO)map.get("mem2");
%>

<br>5. HashMap ��� scriptlet
<br>
map key: mem1 �̸�: <%=vo1.getName() %> �ּ�: <%=vo1.getAddress() %><br>
map key: mem1 �̸�: <%=vo2.getName() %> �ּ�: <%=vo2.getAddress() %><br>
<hr>
<br>6. HashMap ��� el
<br>
map key: mem1 �̸�: ${sessionScope.memMap.mem1.name}  �ּ�: ${sessionScope.memMap.mem1.address}<br>
map key: mem1 �̸�: ${sessionScope.memMap.mem2.name}  �ּ�: ${sessionScope.memMap.mem2.address}<br>
</body>
</html>