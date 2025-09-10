<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doanh thu</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { margin: 0; font-family: Arial, sans-serif; }
        .btn-new-sale {
            background-color: #000; color: #fff; font-weight: 600;
            border-radius: 8px; padding: 8px 16px;
            transition: all 0.3s ease; text-decoration: none;
        }
        .btn-new-sale:hover { background-color: #ffc107; color: #000; }
        .topbar { position: fixed; top: 0; left: 0; width: 100%; background-color: #000; padding: 5px 0; display: flex; align-items: center; z-index: 2000; flex-direction: column; }
        .logo-container { width: 100%; display: flex; justify-content: flex-start; align-items: center; }
        .logo-container img { height: 50px; }
        .yellow-bar { background-color: #FFD700; height: 2px; width: 95%; margin: 5px auto; }
        .navbar { position: fixed; top: 70px; left: 0; width: 100%; background-color: #000 !important; display: flex; justify-content: center; align-items: center; padding: 10px 0; z-index: 1500; }
        .navbar .nav-link { color: #fff !important; }
        .navbar .nav-link:hover { color: #FFD700 !important; }
        .carousel { margin-top: 120px; height: 500px; position: relative; }
        .carousel-item img { height: 100vh; object-fit: cover; }
        .table-overlay { position: fixed; top: 56%; left: 50%; transform: translate(-50%, -50%); max-width: 90%; width: 1100px; max-height: 70vh; background-color: rgba(248,249,250,0.9); padding: 20px; border-radius: 10px; box-shadow: 0 0 15px rgba(0,0,0,0.3); z-index: 2000; overflow-y: auto; overflow-x: auto; }
        .table-overlay table { width: 100%; border-collapse: collapse; }
        .table-overlay th, .table-overlay td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        .table-overlay th { background-color: #f2f2f2; }
    </style>
</head>
<body>

<div class="topbar">
    <div class="logo-container">
        <img src="images/logo.png" alt="Logo">

        <!-- Nút giao dịch mới -->
        <div style="margin-left:auto; margin-right:20px;">
            <a href="${pageContext.request.contextPath}/sale"
               class="btn btn-new-sale">
                🛒 Giao dịch mới
            </a>
        </div>
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
                <li class="nav-item"><a class="nav-link" href="salesHistory">Lịch sử bán</a></li>
                <li class="nav-item"><a class="nav-link active" href="revenue">Doanh thu</a></li>
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
        <h3 class="text-center mb-3">Doanh thu</h3>
        <h3>Lịch sử bán</h3>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Sản phẩm</th>
                <th>Số lượng</th>
                <th>Giá</th>
                <th>Thành tiền</th>
                <th>Khách hàng</th>
                <th>Ngày bán</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sale" items="${sales}">
                <tr>
                    <td>${sale.id}</td>
                    <td>${sale.productName}</td>
                    <td>${sale.quantity}</td>
                    <td>${sale.price}€</td>
                    <td>${sale.price * sale.quantity}</td>
                    <td>${sale.customerName}</td>
                    <td>${sale.saleDate}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
        <h4>Tổng doanh thu: ${totalRevenue} €</h4>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>





