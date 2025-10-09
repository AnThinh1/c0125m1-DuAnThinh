<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form thêm sinh viên</title>
</head>
<body>
<form action="/students/create" method="post">
    Mã sinh viên: <input type="text" name="code"><br/>
    Tên sinh viên: <input type="text" name="name"><br/>
    Điểm số : <input type="number" step="0.1" name="score" /><br/>
    <button type="submit">Add</button>
</form>
</body>
</html>
