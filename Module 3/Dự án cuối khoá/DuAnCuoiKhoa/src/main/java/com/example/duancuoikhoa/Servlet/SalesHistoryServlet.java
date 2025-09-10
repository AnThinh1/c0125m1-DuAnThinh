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

@WebServlet("/salesHistory")
public class SalesHistoryServlet extends HttpServlet {

    private SaleDAO saleDAO;

    @Override
    public void init() {
        saleDAO = new SaleDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Sale> sales = saleDAO.getAllSales();
        request.setAttribute("sales", sales);

        request.getRequestDispatcher("/WEB-INF/salesHistory.jsp").forward(request, response);
    }
}
