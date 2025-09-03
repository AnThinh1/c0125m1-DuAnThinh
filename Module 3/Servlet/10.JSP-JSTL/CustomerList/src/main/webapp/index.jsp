<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách khách hàng</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        img {
            width: 60px;
            height: 60px;
            object-fit: cover;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Danh sách khách hàng</h2>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="c" items="${customerList}">
        <tr>
            <td>${c.name}</td>
            <td>${c.birthday}</td>
            <td>${c.address}</td>
            <td><img src="${c.image}" alt="Ảnh khách hàng"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
