<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { margin: 0; font-family: Arial, sans-serif; }

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

<!-- Topbar + logo + gạch vàng -->
<div class="topbar">
    <div class="logo-container">
        <img src="images/logo.png" alt="Logo">
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
                <li class="nav-item"><a class="nav-link" href="#">Lịch sử bán</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Doanh thu</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Form chỉnh sửa -->
<div class="form-overlay">
    <h3>Chỉnh sửa sản phẩm</h3>
    <form action="${pageContext.request.contextPath}/edit" method="post">
        <input type="hidden" name="id" value="${product.id}">
        <div class="mb-2">
            <label>Tên xe:</label>
            <input type="text" class="form-control" name="name" value="${product.name}" required>
        </div>
        <div class="mb-2">
            <label>Loại:</label>
            <select class="form-control" name="category" required>
                <option value="Xc trail" ${product.category == 'Xc trail' ? 'selected' : ''}>XC Trail</option>
                <option value="Hardtail all mountain" ${product.category == 'Hardtail all mountain' ? 'selected' : ''}>Hardtail All Mountain</option>
                <option value="Fullsuspension enduro" ${product.category == 'Fullsuspension enduro' ? 'selected' : ''}>Fullsuspension Enduro</option>
                <option value="Dirtjump" ${product.category == 'Dirtjump' ? 'selected' : ''}>Dirtjump</option>
            </select>
        </div>

        <div class="mb-2">
            <label>Hãng:</label>
            <input type="text" class="form-control" name="brand" value="${product.brand}">
        </div>
        <div class="mb-2">
            <label>Khung:</label>
            <input type="text" class="form-control" name="frameMaterial" value="${product.frameMaterial}">
        </div>
        <div class="mb-2">
            <label>Năm:</label>
            <input type="number" class="form-control" name="year" value="${product.year}">
        </div>
        <div class="mb-2">
            <label>Size:</label>
            <input type="text" class="form-control" name="size" value="${product.size}">
        </div>
        <div class="mb-2">
            <label>Giá:</label>
            <input type="number" class="form-control" name="price" step="0.01" value="${product.price}">
        </div>
        <div class="mb-2">
            <label>Số lượng:</label>
            <div class="input-group">

                <input type="number" class="form-control text-center" id="stockQuantity" name="stockQuantity" value="${product.stockQuantity}" min="0">
                <button type="button" class="btn btn-outline-secondary" id="decreaseBtn">-</button>
                <button type="button" class="btn btn-outline-secondary" id="increaseBtn">+</button>
                <c:if test="${product.stockQuantity == 0}">
                    <span class="quantity-zero">Hết hàng</span>
                </c:if>
            </div>
        </div>
        <button type="submit" class="btn btn-primary mt-2">Cập nhật</button>
        <a href="list" class="btn btn-secondary mt-2">Hủy</a>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
    const decreaseBtn = document.getElementById('decreaseBtn');
    const increaseBtn = document.getElementById('increaseBtn');
    const quantityInput = document.getElementById('stockQuantity');

    decreaseBtn.addEventListener('click', () => {
        let val = parseInt(quantityInput.value) || 0;
        if(val > 0) val--;
        quantityInput.value = val;
        updateZeroText(val);
    });

    increaseBtn.addEventListener('click', () => {
        let val = parseInt(quantityInput.value) || 0;
        val++;
        quantityInput.value = val;
        updateZeroText(val);
    });

    function updateZeroText(val){
        let zeroText = document.querySelector('.quantity-zero');
        if(val === 0){
            if(!zeroText){
                const span = document.createElement('span');
                span.className = 'quantity-zero';
                span.innerText = 'Hết hàng';
                quantityInput.parentNode.appendChild(span);
            }
        } else {
            if(zeroText) zeroText.remove();
        }
    }
</script>

</body>
</html>
