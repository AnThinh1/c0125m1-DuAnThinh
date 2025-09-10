<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chỉnh sửa giao dịch</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { margin: 0; font-family: Arial, sans-serif; }
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
        /* Topbar */
        .topbar { position: fixed; top: 0; left: 0; width: 100%; background-color: #000; padding: 5px 0; display: flex; flex-direction: column; align-items: center; z-index: 2000; }
        .logo-container { width: 100%; display: flex; justify-content: flex-start; align-items: center; }
        .logo-container img { height: 50px; }
        .yellow-bar { background-color: #FFD700; height: 2px; width: 95%; margin: 5px auto; }

        /* Navbar */
        .navbar { position: fixed; top: 70px; left: 0; width: 100%; background-color: #000 !important; display: flex; justify-content: center; align-items: center; padding: 10px 0; z-index: 1500; }
        .navbar .nav-link { color: #fff !important; }
        .navbar .nav-link:hover { color: #FFD700 !important; }
        .carousel { margin-top: 120px; height: 500px; position: relative; }
        .carousel-item img { height: 100vh; object-fit: cover; }
        /* Form overlay */
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

        .form-overlay .quantity-zero { color: red; margin-left: 10px; font-weight: bold; }
    </style>
</head>
<body>
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
<!-- Navbar -->
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

<!-- Form chỉnh sửa sale -->
<div class="form-overlay">
    <h3>Chỉnh sửa giao dịch</h3>
    <form action="${pageContext.request.contextPath}/edit-sale" method="post">
        <input type="hidden" name="id" value="${sale.id}">

        <div class="mb-2">
            <label>Sản phẩm:</label>
            <select class="form-control" name="productId" required>
                <c:forEach var="product" items="${products}">
                    <option value="${product.id}" ${product.id == sale.productId ? 'selected' : ''}>
                            ${product.name}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-2">
            <label>Số lượng:</label>
            <input type="number" class="form-control" name="quantity" value="${sale.quantity}" min="1" required>
        </div>

        <div class="mb-2">
            <label>Tên khách hàng:</label>
            <input type="text" class="form-control" name="customerName" value="${sale.customerName}" required>
        </div>

        <div class="mb-2">
            <label>Số điện thoại:</label>
            <input type="text" class="form-control" name="customerPhone" value="${sale.customerPhone}" required>
        </div>

        <div class="mb-2">
            <label>Ngày bán:</label>
            <input type="datetime-local" class="form-control"
                   name="saleDate"
                   value="${sale.saleDate != null ? sale.saleDate.toString().replace('T', ' ') : ''}">
        </div>

        <button type="submit" class="btn btn-primary mt-2">Cập nhật</button>
        <a href="salesHistory" class="btn btn-secondary mt-2">Hủy</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
