<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách sinh viên</title></head>
<body>
<h2>Danh sách sinh viên</h2>
<a href="${pageContext.request.contextPath}/students/add">Thêm sinh viên</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Điểm</th>
        <th>Hạng</th>
    </tr>
    <c:forEach var="s" items="${students}">
        <tr>
            <td><c:out value="${s.id}"/></td>
            <td><c:out value="${s.name}"/></td>
            <td><c:out value="${s.gpa}"/></td>
            <td><c:out value="${s.rank}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
