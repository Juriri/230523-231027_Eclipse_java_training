<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�˻�â�Դϴ�. </h3>
<form name=x 
action="<%=request.getContextPath()%>/control?type=search" method="post">
����: <input type="text" name="title">
<input type="submit" value="�˻�">
</form>
    <%-- �˻� ��� ��� --%>
    <% if (request.getAttribute("book") != null) { %>
        <h4>�˻� ���</h4>
        <table>
            <thead>
                <tr>
                    <th>����</th>
                    <th>������</th>
                    <th>���ǻ�</th>
                    <th>����</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${book.author}</td>
                    <td>${book.title}</td>
                    <td>${book.publisher}</td>
                    <td>${book.content}</td>
                </tr>
            </tbody>
        </table>
    <% } %>
</body>
</html>