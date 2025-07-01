<jsp:useBean id="product" scope="request" class="com.example.baitapungdungquanlysanpham.model.Product"/>
<html>
<head><title>Chi tiết sản phẩm</title></head>
<body>
<h1>Thông tin chi tiết</h1>
<p>ID: ${product.id}</p>
<p>Tên: ${product.name}</p>
<p>Giá: ${product.price}</p>
<p>Mô tả: ${product.description}</p>
<p>Nhà sản xuất: ${product.manufacturer}</p>
<a href="/products">Quay lại</a>
</body>
</html>
