<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="model.MemberVO, java.util.HashMap, java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
1. scriptlet으로 회원 정보 출력<br>
<%
MemberVO vo =(MemberVO) session.getAttribute("mvo");
%>
아이디: <%=vo.getId()%>
이름: <%=vo.getName()%>
주소: <%=vo.getAddress()%>
<br>
<hr>
<br>2. el로 회원 정보를 출력<br>
아이디 : ${sessionScope.mvo.id}
이름 : ${sessionScope.mvo.name}
주소 : ${sessionScope.mvo.address}
<hr>
<br>3. 배열
<%String[] name = (String[])session.getAttribute("name");%>
<%=name[0]%>,<%=name[1]%>,<%=name[2]%>
<hr>
<br>4. 배열 출력 el
${sessionScope.name[0]} ${sessionScope.name[1]} ${sessionScope.name[2]}

<%
Map map = (HashMap)session.getAttribute("memMap");
MemberVO vo1 = (MemberVO)map.get("mem1");
MemberVO vo2 = (MemberVO)map.get("mem2");
%>

<br>5. HashMap 출력 scriptlet
<br>
map key: mem1 이름: <%=vo1.getName() %> 주소: <%=vo1.getAddress() %><br>
map key: mem1 이름: <%=vo2.getName() %> 주소: <%=vo2.getAddress() %><br>
<hr>
<br>6. HashMap 출력 el
<br>
map key: mem1 이름: ${sessionScope.memMap.mem1.name}  주소: ${sessionScope.memMap.mem1.address}<br>
map key: mem1 이름: ${sessionScope.memMap.mem2.name}  주소: ${sessionScope.memMap.mem2.address}<br>
</body>
</html>