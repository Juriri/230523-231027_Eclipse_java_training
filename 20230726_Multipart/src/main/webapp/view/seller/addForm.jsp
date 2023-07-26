<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>상품 등록</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/board_style.css">
</head>
<body>
    <h3>상품 등록</h3>
    <a href="${pageContext.request.contextPath}/seller/List">상품 목록</a>
    <form action="${pageContext.request.contextPath}/seller/Add" method="post" enctype="multipart/form-data">
        <label for="name">상품명:</label>
        <input type="text" name="name" id="name"><br>
        
        <label for="quantity">수량:</label>
        <input type="text" name="quantity" id="quantity"><br>
        
        <label for="price">가격:</label>
        <input type="text" name="price" id="price"><br>
        
        <label for="file">상품 이미지 등록:</label>
        <input type="file" name="file" id="file" onchange="previewImage(event)"><br>
        <div id="imagePreview">
            <img id="preview" src="#" alt="Image Preview" style="display: none; max-width: 300px; max-height: 300px;">
        </div>
        
        <label for="content">상세 설명:</label>
        <textarea rows="10" cols="30" name="content" id="content"></textarea><br>
        
        <input type="reset" name="cancel" value="취소">
        <input type="submit" name="register" value="등록">
    </form>
    
    <script>
        function previewImage(event) {
            var input = event.target;
            var preview = document.getElementById('preview');
            var imagePreview = document.getElementById('imagePreview');

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function(e) {
                    preview.src = e.target.result;
                };

                reader.readAsDataURL(input.files[0]);
                imagePreview.style.display = 'block'; // Show the image preview container
            } else {
                preview.src = "#";
                imagePreview.style.display = 'none'; // Hide the image preview container if no file selected
            }
        }
    </script>
</body>
</html>
