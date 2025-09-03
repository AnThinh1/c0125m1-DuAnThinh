<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách nhân viên</title></head>
<body>
<h2>Danh sách nhân viên</h2>
<form method="get" action="employees">
    <input type="text" name="q" placeholder="Tìm theo tên hoặc email"/>
    <select name="sort">
        <option value="">Sắp xếp</option>
        <option value="name">Tên (A-Z)</option>
        <option value="salary">Lương (cao - thấp)</option>
        <option value="hire_date">Ngày vào làm (mới - cũ)</option>
    </select>
    <button type="submit">Lọc</button>
</form>
<a href="employees?action=create">Thêm mới nhân viên</a>
<table border="1">
    <tr>
        <th>ID</th><th>Họ tên</th><th>Email</th><th>Phone</th><th>Phòng ban</th><th>Lương</th><th>Ngày vào làm</th>
    </tr>
    <c:forEach var="e" items="${employees}">
        <tr>
            <td>${e.id}</td>
            <td>${e.fullName}</td>
            <td>${e.email}</td>
            <td>${e.phone}</td>
            <td>${e.department}</td>
            <td>${e.salary}</td>
            <td>${e.hireDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
