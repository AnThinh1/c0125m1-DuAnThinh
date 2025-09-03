<%--
  Created by IntelliJ IDEA.
  User: macbookairm2
  Date: 29/8/25
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<style>
    .btn {
        display: inline-block;
        padding: 8px 16px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
    }
    .btn:hover {
        background-color: #45a049;
    }

</style>
<body>
<form action="./create-employee" method="post">
    <input type="text" name = "fullname" placeholder="Nhập họ và tên">
    <input type="text" name = "email" placeholder="Nhập email"><br>
    <input type="text" name = "phone" placeholder="Nhập số điện thoại">
    <input type="text" name = "department" placeholder="Nhập phòng ban"><br>
    <input type="text" name = "salary" placeholder="Nhập mức lương">
    <input type="date" name="hiredate" placeholder="Nhập ngày đi làm">
    <button type="submit">Lưu</button>
    <a href="<c:url value='/employees'/>" class="btn">Xem danh sách</a>

</form>
</body>
</html>
