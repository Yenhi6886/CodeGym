<jsp:useBean id="product" scope="request" class="com.example.baitapungdungquanlysanpham.model.Product"/>
<html>
<head><title>Xoá sản phẩm</title></head>
<body>
<%-- Kiểm tra nếu không có product thì báo lỗi --%>
<c:if test="${product == null}">
    <h2>Không tìm thấy sản phẩm!</h2>
    <a href="/products">Quay lại</a>
</c:if>
<c:if test="${product != null}">
<h1>Bạn chắc chắn muốn xoá sản phẩm này?</h1>
<p>Tên: ${product.name}</p>
<p>Giá: ${product.price}</p>
<form method="post" action="/products?action=delete">
    <input type="hidden" name="id" value="${product.id}">
    <button type="submit">Xoá</button>
</form>
<a href="/products">Huỷ</a>
</c:if>
</body>
</html>
