<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="product" scope="request" class="com.example.baitapungdungquanlysanpham.model.Product"/>
<html>
<head><title>Sửa sản phẩm</title></head>
<body>
<h1>Sửa sản phẩm</h1>
<form method="post" action="/products?action=edit">
    <input type="hidden" name="id" value="${product.id}">
    Tên: <input type="text" name="name" value="${product.name}"><br>
    Giá: <input type="number" name="price" value="${product.price}"><br>
    Mô tả: <input type="text" name="description" value="${product.description}"><br>
    Nhà sản xuất: <input type="text" name="manufacturer" value="${product.manufacturer}"><br>
    <button type="submit">Cập nhật</button>
</form>
<a href="/products">Quay lại</a>
</body>
</html>
