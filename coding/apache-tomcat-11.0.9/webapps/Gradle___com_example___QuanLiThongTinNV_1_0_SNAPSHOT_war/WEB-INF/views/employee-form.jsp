<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Thêm nhân viên</title></head>
<body>
<h2>Thêm nhân viên</h2>
<form method="post" action="employees?action=create">
    Họ tên*: <input type="text" name="full_name" required/><br/>
    Email*: <input type="email" name="email" required/><br/>
    Phone: <input type="text" name="phone"/><br/>
    Phòng ban: <input type="text" name="department"/><br/>
    Lương: <input type="number" name="salary" step="0.01" value="0"/><br/>
    Ngày vào làm*: <input type="date" name="hire_date" required/><br/>
    <button type="submit">Lưu</button>
</form>
<a href="employees">Quay lại danh sách</a>
</body>
</html>
