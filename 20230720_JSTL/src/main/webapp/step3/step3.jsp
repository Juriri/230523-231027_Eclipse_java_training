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
JSTL IF ���� <br><br>
<c:if test="true">
true�̹Ƿ� ����
</c:if>
<hr>
<c:if test="false">
<script type="text/javascript">
alert("������");
</script>
</c:if>
<hr>
<a href="step3.jsp?command=java">�� ������ ȣ�� command ����</a><br>
${param.command }
<br>
<!-- param�� command���� java�̸� true ��ȯ�Ͽ� ���� -->
<c:if test="${param.command=='java' }">
${param.command } �̹Ƿ� if ����
</c:if>
<hr>
<br>
</body>
</html>