<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="display-discount" method="post">
    <input type="text" name="description" placeholder="Product Description"><br>
    <input type="number" step="0.01" name="price" placeholder="List Price"><br>
    <input type="number" step="0.01" name="percent"/><br><br>
    <input type="submit" value="Calculate Discount">
</form>
</body>
</html>