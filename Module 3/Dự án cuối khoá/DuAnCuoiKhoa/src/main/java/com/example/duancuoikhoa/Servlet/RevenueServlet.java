package com.example.duancuoikhoa.Servlet;

import com.example.duancuoikhoa.Dao.SaleDAO;
import com.example.duancuoikhoa.Model.Sale;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/revenue")
public class RevenueServlet extends HttpServlet {
    private SaleDAO saleDAO;

    @Override
    public void init() {
        saleDAO = new SaleDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Sale> sales = saleDAO.getAllSales();
        double totalRevenue = saleDAO.getTotalRevenue();

        request.setAttribute("sales", sales);
        request.setAttribute("totalRevenue", totalRevenue);

        request.getRequestDispatcher("/WEB-INF/revenue.jsp").forward(request, response);
    }
}

