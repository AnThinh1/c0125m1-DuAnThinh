<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- Họ tên*, Email*, Phone, Phòng ban, Lương, Ngày vào làm. -->
<!--
 Cách 1: if <id> then action="./edit-employee" else action="./create-employee"
 Cách 2: action=""
 -->
<form action="" method="post">
    Full Name: <input type="text" name="full_name" value="${employee.fullName}"> <br/>
    Email: <input type="text" name="email" value="${employee.email}"> <br/>
    Phone: <input type="text" name="phone" value="${employee.phone}"> <br/>
    Department: <select name="department">
                    <option value="">Chưa có phòng ban</option>
                    <c:forEach var="department" items="${departments}">
                        <option value="${department.id}">${department.name}</option>
                    </c:forEach>
                </select>
    <br/>
    <button type="submit">Lưu</button>
</form>
</body>
</html>
