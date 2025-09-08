<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { margin: 0; font-family: Arial, sans-serif; }
        .topbar { position: fixed; top: 0; left: 0; width: 100%; background-color: #000000; padding: 5px 0px; display: flex; align-items: center; z-index: 2000; flex-direction: column; }
        .logo-container { width: 100%; display: flex; justify-content: flex-start; align-items: center; }
        .logo-container img { height: 50px; }
        .yellow-bar { background-color: #FFD700; height: 2px; width: 95%; margin: 5px auto; }
        .navbar { position: fixed; top: 70px; left: 0; width: 100%; background-color: #000000 !important; display: flex; justify-content: center; align-items: center; padding: 10px 0; z-index: 1500; }
        .navbar .nav-link { color: #ffffff !important; }
        .navbar .nav-link:hover { color: #FFD700 !important; }
        .carousel { margin-top: 120px; height: 500px; position: relative; }
        .carousel-item img { height: 100vh; object-fit: cover; }
        .table-overlay { position: fixed; top: 56%; left: 50%; transform: translate(-50%, -50%); max-width: 90%; width: 1000px; max-height: 70vh; background-color: rgba(248, 249, 250, 0.85); padding: 20px; border-radius: 10px; box-shadow: 0 0 15px rgba(0,0,0,0.3); z-index: 2000; overflow-y: auto; overflow-x: auto; }
        .table-overlay table { width: 100%; border-collapse: collapse; }
        .table-overlay th, .table-overlay td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        .table-overlay th { background-color: #f2f2f2; }
        .add-product { margin-bottom: 15px; display: inline-block; }
        .quantity-zero { color: red; font-weight: bold; }
    </style>
</head>
<body>

<div class="topbar">
    <div class="logo-container">
        <img src="images/logo.png" alt="Logo">
    </div>
    <div class="yellow-bar"></div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">AT.EnduroShop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link" href="list">Danh sách sản phẩm</a></li>
                <li class="nav-item"><a class="nav-link" href="create">Thêm sản phẩm</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Lịch sử bán</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Doanh thu</a></li>
            </ul>
        </div>
    </div>
</nav>

<div id="bikeCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="images/bike1.jpg" class="d-block w-100" alt="Bike 1">
        </div>
        <div class="carousel-item">
            <img src="images/bike2.jpg" class="d-block w-100" alt="Bike 2">
        </div>
        <div class="carousel-item">
            <img src="images/bike3.jpg" class="d-block w-100" alt="Bike 3">
        </div>
        <div class="carousel-item">
            <img src="images/bike4.jpg" class="d-block w-100" alt="Bike 4">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#bikeCarousel" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#bikeCarousel" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>

    <div class="table-overlay">
        <table>
            <tr>
                <th>ID</th>
                <th>Tên xe</th>
                <th>Loại</th>
                <th>Hãng</th>
                <th>Khung</th>
                <th>Năm</th>
                <th>Size</th>
                <th>Giá</th>
                <th>Số lượng</th>
                <th>Hành động</th>
            </tr>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.category}</td>
                    <td>${p.brand}</td>
                    <td>${p.frameMaterial}</td>
                    <td>${p.year}</td>
                    <td>${p.size}</td>
                    <td>${p.price}€</td>
                    <td>
                        <c:choose>
                            <c:when test="${p.stockQuantity > 0}">
                                ${p.stockQuantity}
                            </c:when>
                            <c:otherwise>
                                <span class="quantity-zero">Hết hàng</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/edit?id=${p.id}" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="${pageContext.request.contextPath}/delete?id=${p.id}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?');">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
