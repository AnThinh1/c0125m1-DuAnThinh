<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Hoá đơn</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .btn-new-sale {
            background-color: #000;      /* nền đen */
            color: #fff;                /* chữ trắng */
            font-weight: 600;
            border-radius: 8px;         /* bo góc nhẹ */
            padding: 8px 16px;
            transition: all 0.3s ease;
            text-decoration: none;
        }

        .btn-new-sale:hover {
            background-color: #ffc107;  /* vàng khi hover */
            color: #000;                /* chữ đen khi hover */
        }
        /* Thanh topbar chứa logo */
        .topbar {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: #000000;
            padding: 5px 0px;
            display: flex;
            align-items: center;
            z-index: 2000;
            flex-direction: column;
        }

        .logo-container {
            width: 100%;
            display: flex;
            justify-content: flex-start; /* logo sang trái */
            align-items: center;
        }

        .logo-container img {
            height: 50px;
        }

        /* Thanh vàng */
        .yellow-bar {
            background-color: #FFD700;
            height: 2px;
            width: 95%;        /* chiếm 80% chiều ngang */
            margin: 5px auto;  /* căn giữa */
        }

        /* Thanh công cụ */
        .navbar {
            position: fixed;
            top: 70px; /* đẩy xuống dưới topbar + gạch vàng */
            left: 0;
            width: 100%;
            background-color: #000000 !important;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 10px 0;
            z-index: 1500;
        }

        .navbar .nav-link {
            color: #ffffff !important;
        }

        .navbar .nav-link:hover {
            color: #FFD700 !important;
        }

        /* Slider */
        .carousel {
            margin-top: 120px; /* trừ phần topbar + navbar */
        }

        .carousel-item img {
            height: 100vh;
            object-fit: cover;
        }
        .form-overlay {
            position: fixed;
            top: 58%;
            left: 50%;
            transform: translate(-50%, -50%);
            max-height: 83vh;
            max-width: 600px;
            width: 90%;
            background-color: rgba(248, 249, 250, 0.85);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.3);
            z-index: 2000;
            overflow-y: auto; overflow-x: auto;
        }
    </style>
</head>
<body>

<!-- Topbar + logo + gạch vàng -->
<div class="topbar">
    <div class="logo-container">
        <img src="images/logo.png" alt="Logo">

        <!-- Nút giao dịch mới bên phải -->
        <div style="margin-left:auto; margin-right:20px;">
            <a href="${pageContext.request.contextPath}/sale"
               class="btn btn-new-sale">
                🛒 Giao dịch mới
            </a>
        </div>
    </div>
    <div class="yellow-bar"></div>
</div>

<!-- Thanh công cụ -->
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
                <li class="nav-item"><a class="nav-link" href="revenue">Doanh thu</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="form-overlay">
    <h3>Thông tin hoá đơn</h3>
    <form action="${pageContext.request.contextPath}/sale" method="post">
        <!-- Chọn sản phẩm -->
        <label>Sản phẩm:</label><br>
        <select name="productId" class="form-select" required>
            <c:forEach var="product" items="${productList}">
                <option value="${product.id}">
                        ${product.name} - ${product.brand} (Còn: ${product.stockQuantity})
                </option>
            </c:forEach>
        </select>

        <!-- Số lượng -->
        <label>Số lượng bán:</label><br>
        <input type="number" name="quantity" value="1" min="1" required><br><br>

        <!-- Thông tin khách hàng -->
        <label>Tên khách hàng:</label><br>
        <input type="text" name="customerName" required><br><br>

        <label>Số điện thoại:</label><br>
        <input type="text" name="customerPhone" required><br><br>

        <button type="submit">Xác nhận bán</button>
    </form>
</div>

<!-- Slider -->
<div id="bikeCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="images/bike1.jpg" class="d-block w-100" alt="Bike 1">
        </div>
        <div class="carousel-item">
            <img src="images/bike2.jpg" class="d-block w-100" alt="Bike 2">
        </div>
        <div class="carousel-item">
            <img src="images/bike3.jpg" class="d-block w-100" alt="Bike3">
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
</div>


<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
