<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Mặt Bằng</title>
</head>
<body>
<h2>Thêm Mặt Bằng</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/addMatBang" method="post">
    Mã mặt bằng:
    <input type="text" name="maMatBang" required pattern="[A-Z0-9]{3}-[A-Z0-9]{2}-[A-Z0-9]{2}"
           title="Ví dụ: 123-AB-45" value="${maMatBang}"><br><br>

    Trạng thái:
    <select name="trangThai" required>
        <option value="Trống" <c:if test="${trangThai == 'Trống'}">selected</c:if>>Trống</option>
        <option value="Hạ tầng" <c:if test="${trangThai == 'Hạ tầng'}">selected</c:if>>Hạ tầng</option>
        <option value="Đầy đủ" <c:if test="${trangThai == 'Đầy đủ'}">selected</c:if>>Đầy đủ</option>
    </select><br><br>

    Diện tích: <input type="number" name="dienTich" min="21" required value="${dienTich}"><br><br>
    Tầng: <input type="number" name="tang" min="1" max="15" required value="${tang}"><br><br>

    Loại mặt bằng:
    <select name="loaiMatBang" required>
        <option value="Văn phòng chia sẻ" <c:if test="${loaiMatBang == 'Văn phòng chia sẻ'}">selected</c:if>>Văn phòng chia sẻ</option>
        <option value="Văn phòng trọn gói" <c:if test="${loaiMatBang == 'Văn phòng trọn gói'}">selected</c:if>>Văn phòng trọn gói</option>
    </select><br><br>

    Giá tiền: <input type="number" name="giaTien" min="1000001" required value="${giaTien}"><br><br>

    Ngày bắt đầu: <input type="date" name="ngayBatDau" required value="${ngayBatDau}"><br><br>
    Ngày kết thúc: <input type="date" name="ngayKetThuc" required value="${ngayKetThuc}"><br><br>

    <input type="submit" value="Thêm">
</form>

<br>
<a href="${pageContext.request.contextPath}/listMatBang">Quay lại danh sách</a>
</body>
</html>
