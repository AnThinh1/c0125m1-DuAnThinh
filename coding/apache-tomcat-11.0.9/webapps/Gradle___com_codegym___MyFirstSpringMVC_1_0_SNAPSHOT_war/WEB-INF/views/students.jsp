<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>

<c:if test="${not empty message}">
    <div style="color: green;">${message}</div>
</c:if>

<h3>Danh sách sinh viên</h3>

<table border="1" cellspacing="0" cellpadding="5">
    <thead>
    <tr>
        <th>Mã sinh viên</th>
        <th>Tên sinh viên</th>
        <th>Điểm</th>
        <th>Xếp loại (GPA)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>
                <a href="/students/${student.code}">
                        ${student.code}
                </a>
            </td>
            <td>${student.name}</td>
            <td>${student.score}</td>
            <td>${student.gpa}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br/>
<a href="/students/create">+ Thêm sinh viên mới</a>

</body>
</html>
