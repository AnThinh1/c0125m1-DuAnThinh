<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm sản phẩm mới</title>
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

        /* Carousel */
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

<!-- Topbar + logo -->
<div class="topbar">
    <div class="logo-container">
        <img src="images/logo.png" alt="Logo">
    </div>
    <div class="yellow-bar"></div>
</div>

<!-- Carousel -->
<div id="bikeCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active"><img src="images/bike1.jpg" class="d-block w-100" alt="Bike 1"></div>
        <div class="carousel-item"><img src="images/bike2.jpg" class="d-block w-100" alt="Bike 2"></div>
        <div class="carousel-item"><img src="images/bike3.jpg" class="d-block w-100" alt="Bike 3"></div>
        <div class="carousel-item"><img src="images/bike4.jpg" class="d-block w-100" alt="Bike 4"></div>
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

<!-- Form thêm mới -->
<div class="form-overlay">
    <h3>Thêm sản phẩm mới</h3>
    <form action="${pageContext.request.contextPath}/create" method="post">
        <div class="mb-2">
            <label>Tên xe:</label>
            <input type="text" class="form-control" name="name" required>
        </div>
        <div class="mb-2">
            <label>Loại:</label>
            <select class="form-control" name="category" required>
                <option value="Xc trail">XC Trail</option>
                <option value="Hardtail all mountain">Hardtail All Mountain</option>
                <option value="Fullsuspension enduro">Fullsuspension Enduro</option>
                <option value="Dirtjump">Dirtjump</option>
            </select>
        </div>
        <div class="mb-2">
            <label>Hãng:</label>
            <input type="text" class="form-control" name="brand">
        </div>
        <div class="mb-2">
            <label>Khung:</label>
            <select class="form-select" name="frameMaterial">
                <option value="Nhôm">Nhôm</option>
                <option value="Carbon">Carbon</option>
            </select>
        </div>
        <div class="mb-2">
            <label>Năm:</label>
            <input type="number" class="form-control" name="year">
        </div>
        <div class="mb-2">
            <label>Size:</label>
            <select name="size" class="form-select">
                <option value="27.5">27.5</option>
                <option value="29">29</option>
            </select>
        </div>
        <div class="mb-2">
            <label>Giá:</label>
            <input type="number" class="form-control" name="price" step="0.01">
        </div>
        <div class="mb-2">
            <label>Số lượng:</label>
            <div class="input-group">
                <input type="number" class="form-control text-center" id="stockQuantity" name="stockQuantity" value="0" min="0">
                <button type="button" class="btn btn-outline-secondary" id="decreaseBtn">-</button>
                <button type="button" class="btn btn-outline-secondary" id="increaseBtn">+</button>
            </div>
        </div>
        <button type="submit" class="btn btn-success mt-2">Thêm sản phẩm</button>
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
    });

    increaseBtn.addEventListener('click', () => {
        let val = parseInt(quantityInput.value) || 0;
        val++;
        quantityInput.value = val;
    });
</script>

</body>
</html>
