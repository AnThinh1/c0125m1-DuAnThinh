<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>

<a href="./create-employee">Thêm mới nhân viên</a>

<table border="1">
    <tr>
        <td>ID</td>
        <td><a href="./employees?sortBy=full_name">Full name</a></td>
        <td><a href="./employees?sortBy=email">Email</a></td>
        <td><a href="./employees?sortBy=phone">Phone</a></td>
        <td>Department</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.fullName}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>${employee.departmentName}</td>
            <td>
                <a href="./edit-employee?id=${employee.id}">Sửa</a> |
                <a href="./delete-employee?id=${employee.id}">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
