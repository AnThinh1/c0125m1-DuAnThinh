package com.example.duancuoikhoa.Servlet;

import com.example.duancuoikhoa.Dao.ProductDAO;
import com.example.duancuoikhoa.Model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");
        List<Product> products;
        if (category != null && !category.isEmpty()) {
            products = productDAO.getProductsByCategory(category);
        } else {
            products = productDAO.getAllProducts();
        }
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
    }
}
