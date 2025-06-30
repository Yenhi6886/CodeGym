<%@ page import="com.example.contactcsvdemo.Contact" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách liên hệ</title>
</head>
<body>
<h2>📒 Danh bạ</h2>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<div style="color: red;"><%= error %>
</div>
<%
    }
%>
<table border="1" cellpadding="5">
    <tr>
        <th>Tên</th>
        <th>SĐT</th>
        <th>Email</th>
    </tr>
    <%
        List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
        if (contacts != null && !contacts.isEmpty()) {
            for (Contact c : contacts) {
    %>
    <tr>
        <td><%= c.getName() %>
        </td>
        <td><%= c.getPhone() %>
        </td>
        <td><%= c.getEmail() %>
        </td>
    </tr>
    <%
        }
    } else if (error == null) {
    %>
    <tr>
        <td colspan="3" style="color: gray;">Không có dữ liệu liên hệ.</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
