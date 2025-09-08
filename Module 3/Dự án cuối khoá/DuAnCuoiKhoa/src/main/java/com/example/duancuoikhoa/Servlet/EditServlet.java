package com.example.duancuoikhoa.Servlet;

import com.example.duancuoikhoa.Dao.ProductDAO;
import com.example.duancuoikhoa.Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Product product = productDAO.getProductById(id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
            } catch (NumberFormatException ignored) {}
        } else {
            response.sendRedirect(request.getContextPath() + "/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Product product = new Product();
        product.setId(Integer.parseInt(request.getParameter("id")));
        product.setName(request.getParameter("name"));
        product.setCategory(request.getParameter("category"));
        product.setBrand(request.getParameter("brand"));
        product.setFrameMaterial(request.getParameter("frameMaterial"));
        product.setSize(request.getParameter("size"));

        try { product.setYear(Integer.parseInt(request.getParameter("year"))); } catch(Exception ignored){}
        try { product.setPrice(new BigDecimal(request.getParameter("price"))); } catch(Exception ignored){}
        try { product.setStockQuantity(Integer.parseInt(request.getParameter("stockQuantity"))); } catch(Exception ignored){}

        productDAO.update(product); // update vào DB

        response.sendRedirect(request.getContextPath() + "/list");
    }
}
