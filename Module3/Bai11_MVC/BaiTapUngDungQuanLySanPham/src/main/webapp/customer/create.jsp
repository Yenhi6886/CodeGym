<html>
<head><title>Thêm sản phẩm</title></head>
<body>
<h1>Thêm mới sản phẩm</h1>
<form method="post" action="/products?action=create">
    ID: <input type="number" name="id"><br>
    Tên: <input type="text" name="name"><br>
    Giá: <input type="number" name="price"><br>
    Mô tả: <input type="text" name="description"><br>
    Nhà sản xuất: <input type="text" name="manufacturer"><br>
    <button type="submit">Lưu</button>
</form>
<a href="/products">Quay lại</a>
</body>
</html>
