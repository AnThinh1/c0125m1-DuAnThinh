<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Thêm sinh viên</title></head>
<body>
<h2>Thêm sinh viên</h2>
<form action="${pageContext.request.contextPath}/students/add" method="post">
    Họ tên: <input type="text" name="name"/><br/>
    Điểm: <input type="text" name="gpa"/><br/>
    <button type="submit">Lưu</button>
</form>
</body>
</html>
