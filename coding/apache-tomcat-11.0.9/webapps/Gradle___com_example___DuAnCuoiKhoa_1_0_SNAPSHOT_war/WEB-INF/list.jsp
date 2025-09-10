<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm trong kho</h2>

<a href="create.jsp">➕ Thêm sản phẩm mới</a>
<br><br>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tên xe</th>
        <th>Loại</th>
        <th>Hãng</th>
        <th>Frame</th>
        <th>Năm</th>
        <th>Size</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Tình trạng</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.category}</td>
            <td>${p.brand}</td>
            <td>${p.frameMaterial}</td>
            <td>${p.year}</td>
            <td>${p.size}</td>
            <td>${p.price}</td>
            <td>${p.stockQuantity}</td>
            <td>${p.status}</td>
            <td>
                <a href="edit?id=${p.id}">Sửa</a> |
                <a href="delete?id=${p.id}">Xóa</a> |
                <a href="sell?id=${p.id}">Bán</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
