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

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setCategory(request.getParameter("category"));
        product.setBrand(request.getParameter("brand"));
        product.setFrameMaterial(request.getParameter("frameMaterial"));
        product.setSize(request.getParameter("size"));

        try {
            product.setYear(Integer.parseInt(request.getParameter("year")));
        } catch (NumberFormatException ignored) {}

        try {
            product.setPrice(new BigDecimal(request.getParameter("price")));
        } catch (NumberFormatException ignored) {}

        try {
            product.setStockQuantity(Integer.parseInt(request.getParameter("stockQuantity")));
        } catch (NumberFormatException ignored) {}

        productDAO.insert(product);

        response.sendRedirect(request.getContextPath() + "/list");
    }
}
