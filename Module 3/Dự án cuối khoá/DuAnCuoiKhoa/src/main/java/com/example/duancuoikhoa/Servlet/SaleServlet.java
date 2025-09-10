package com.example.duancuoikhoa.Servlet;

import com.example.duancuoikhoa.Dao.ProductDAO;
import com.example.duancuoikhoa.Dao.SaleDAO;
import com.example.duancuoikhoa.Model.Product;
import com.example.duancuoikhoa.Model.Sale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/sale")
public class SaleServlet extends HttpServlet {

    private ProductDAO productDAO;
    private SaleDAO saleDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
        saleDAO = new SaleDAO();
    }

    // Hiển thị form bán hàng
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> productList = productDAO.getAllProducts();
        request.setAttribute("productList", productList);

        request.getRequestDispatcher("/WEB-INF/sale.jsp").forward(request, response);
    }

    // Xử lý khi submit form
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String customerName = request.getParameter("customerName");
        String customerPhone = request.getParameter("customerPhone");

        Product product = productDAO.getProductById(productId);

        if (product != null && product.getStockQuantity() >= quantity) {
            // Lưu giao dịch
            Sale sale = new Sale();
            sale.setProductId(productId);
            sale.setQuantity(quantity);
            sale.setCustomerName(customerName);
            sale.setCustomerPhone(customerPhone);
            sale.setSaleDate(LocalDateTime.now());
            saleDAO.insert(sale);

            // Trừ kho
            product.setStockQuantity(product.getStockQuantity() - quantity);
            productDAO.update(product);

            // Redirect sang trang lịch sử bán
            response.sendRedirect(request.getContextPath() + "/salesHistory");
        } else {
            // Không đủ hàng → quay lại form kèm thông báo
            request.setAttribute("error", "Sản phẩm không đủ số lượng tồn kho!");
            doGet(request, response);
        }
    }
}
