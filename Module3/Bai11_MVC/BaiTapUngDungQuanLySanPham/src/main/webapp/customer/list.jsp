<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>

<form action="/products" method="get">
    <input type="hidden" name="action" value="search"/>
    <input type="text" name="name" placeholder="Tìm theo tên">
    <button type="submit">Tìm</button>
</form>

<a href="/products?action=create">Thêm mới</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Nhà sản xuất</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.manufacturer}</td>
            <td>
                <a href="/products?action=view&id=${product.id}">Xem</a>
                <a href="/products?action=edit&id=${product.id}">Sửa</a>
                <a href="/products?action=delete&id=${product.id}">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
