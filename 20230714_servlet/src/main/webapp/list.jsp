<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <h1>Book List</h1>
    
    <table>
        <thead>
            <tr>
                <th>Author</th>
                <th>Title</th>
                <th>Publisher</th>
                <th>Content</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${bookList}" var="book">
                <tr>
                	<td>${book.num}</td>
                    <td>${book.author}</td>
                    <td>${book.title}</td>
                    <td>${book.publisher}</td>
                    <td>${book.content}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>