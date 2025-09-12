<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách mặt bằng</title>
</head>
<body>
<h2>Danh sách Mặt Bằng</h2>

<a href="${pageContext.request.contextPath}/addMatBang">Thêm mặt bằng mới</a>
<br/><br/>

<form method="get" action="listMatBang">
    Loại mặt bằng:
    <select name="loaiMatBang">
        <option value="">--Tất cả--</option>
        <option value="Văn phòng chia sẻ" <c:if test="${param.loaiMatBang == 'Văn phòng chia sẻ'}">selected</c:if>>Văn phòng chia sẻ</option>
        <option value="Văn phòng trọn gói" <c:if test="${param.loaiMatBang == 'Văn phòng trọn gói'}">selected</c:if>>Văn phòng trọn gói</option>
    </select>

    Giá tiền <= <input type="number" name="giaTien" value="${param.giaTien}"/>

    Tầng: <input type="number" name="tang" min="1" max="15" value="${param.tang}"/>

    <button type="submit">Lọc</button>
</form>

<br/>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Mã MB</th>
        <th>Trạng thái</th>
        <th>Diện tích</th>
        <th>Tầng</th>
        <th>Loại MB</th>
        <th>Giá tiền</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Chỉnh sửa/Xóa</th>
    </tr>
    <c:forEach var="mb" items="${matBangList}">
        <tr>
            <td>${mb.maMatBang}</td>
            <td>${mb.trangThai}</td>
            <td>${mb.dienTich}</td>
            <td>${mb.tang}</td>
            <td>${mb.loaiMatBang}</td>
            <td>${mb.giaTien}</td>
            <td>${mb.ngayBatDau}</td>
            <td>${mb.ngayKetThuc}</td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/deleteMatBang" style="display:inline;">
                    <input type="hidden" name="maMatBang" value="${mb.maMatBang}"/>
                    <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa mặt bằng này?')">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
