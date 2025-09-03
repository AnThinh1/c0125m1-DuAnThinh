<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>

<h2>Danh sách nhân viên</h2>
<a href="<c:url value='/create-employee'/>">Thêm mới</a>
<form action="<c:url value='/employees'/>" method="get">
    <input type="text" name="q" placeholder="Nhập tên hoặc email cần tìm" />
    <button type="submit">Tìm kiếm</button>
</form>

<table border="1" cellpadding="6" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Full name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Hire date</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.fullName}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>${employee.hireDate}</td>
            <td>
                <a href="./edit-employee?id=${employee.id}">Sửa</a>
                <a href="./delete-employee?id=${employee.id}">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
