package com.example.duancuoikhoa.Servlet;

import com.example.duancuoikhoa.Dao.SaleDAO;
import com.example.duancuoikhoa.Dao.ProductDAO;
import com.example.duancuoikhoa.Model.Sale;
import com.example.duancuoikhoa.Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/edit-sale")
public class EditSaleServlet extends HttpServlet {
    private SaleDAO saleDAO;
    private ProductDAO productDAO;

    @Override
    public void init() {
        saleDAO = new SaleDAO();
        productDAO = new ProductDAO();
    }

    // Hiển thị form edit
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Sale sale = saleDAO.findById(id);
            List<Product> products = productDAO.getAllProducts();

            request.setAttribute("sale", sale);
            request.setAttribute("products", products);
            request.getRequestDispatcher("/WEB-INF/editSale.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Lỗi khi load form edit");
        }
    }

    // Xử lý update
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));   // lấy id để update
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String customerName = request.getParameter("customerName");
            String customerPhone = request.getParameter("customerPhone");

            Sale sale = new Sale();
            sale.setId(id);
            sale.setProductId(productId);
            sale.setQuantity(quantity);
            sale.setCustomerName(customerName);
            sale.setCustomerPhone(customerPhone);
            sale.setSaleDate(LocalDateTime.now());

            saleDAO.update(sale);

            // redirect về danh sách lịch sử bán
            response.sendRedirect("salesHistory");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Lỗi khi update sale");
        }
    }
}
