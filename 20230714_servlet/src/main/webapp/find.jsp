<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>검색창입니다. </h3>
<form name=x 
action="<%=request.getContextPath()%>/control?type=search" method="post">
제목: <input type="text" name="title">
<input type="submit" value="검색">
</form>
    <%-- 검색 결과 출력 --%>
    <% if (request.getAttribute("book") != null) { %>
        <h4>검색 결과</h4>
        <table>
            <thead>
                <tr>
                    <th>저자</th>
                    <th>도서명</th>
                    <th>출판사</th>
                    <th>내용</th>
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