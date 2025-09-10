package com.example.duancuoikhoa.Servlet;

import com.example.duancuoikhoa.Dao.SaleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/delete-sale")
public class DeleteSaleServlet extends HttpServlet {
    private SaleDAO saleDAO;

    @Override
    public void init() {
        saleDAO = new SaleDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        saleDAO.delete(id);
        response.sendRedirect("salesHistory");
    }
}
