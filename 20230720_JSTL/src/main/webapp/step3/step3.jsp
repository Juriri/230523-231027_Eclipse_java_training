<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
JSTL IF 연습 <br><br>
<c:if test="true">
true이므로 수행
</c:if>
<hr>
<c:if test="false">
<script type="text/javascript">
alert("하하하");
</script>
</c:if>
<hr>
<a href="step3.jsp?command=java">현 페이지 호출 command 전달</a><br>
${param.command }
<br>
<!-- param의 command값이 java이면 true 반환하여 수행 -->
<c:if test="${param.command=='java' }">
${param.command } 이므로 if 수행
</c:if>
<hr>
<br>
</body>
</html>