<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm mới</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>

<form action="create" method="post">
    Tên xe: <input type="text" name="name" required><br><br>

    Loại:
    <select name="category">
        <option value="XC Trail">XC Trail</option>
        <option value="Hardtail">Hardtail</option>
        <option value="Enduro">Enduro</option>
        <option value="Dirtjump">Dirtjump</option>
    </select>
    <br><br>

    Hãng: <input type="text" name="brand" required><br><br>

    Frame:
    <input type="radio" name="frameMaterial" value="Nhôm" checked> Nhôm
    <input type="radio" name="frameMaterial" value="Carbon"> Carbon
    <br><br>

    Năm: <input type="number" name="year" required><br><br>

    Size:
    <input type="radio" name="size" value="27.5" checked> 27.5
    <input type="radio" name="size" value="29"> 29
    <br><br>

    Giá: <input type="number" name="price" required><br><br>

    Số lượng: <input type="number" name="stockQuantity" required><br><br>

    Tình trạng:
    <input type="radio" name="status" value="Còn" checked> Còn
    <input type="radio" name="status" value="Hết"> Hết
    <br><br>

    <input type="submit" value="Thêm sản phẩm">
</form>

<br>
<a href="list">⬅ Quay lại danh sách</a>
</body>
</html>
