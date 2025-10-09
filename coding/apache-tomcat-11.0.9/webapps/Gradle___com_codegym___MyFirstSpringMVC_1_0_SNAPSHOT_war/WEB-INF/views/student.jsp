<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin sinh viên</title>
</head>
<body>
<h2>Thông tin chi tiết sinh viên</h2>

<p>Mã SV: ${student.code}</p>
<p>Tên: ${student.name}</p>
<p>Điểm: ${student.score}</p>
<p>Xếp loại (GPA): ${student.gpa}</p>

<br/>
<a href="/students">Quay lại danh sách</a>
</body>
</html>
