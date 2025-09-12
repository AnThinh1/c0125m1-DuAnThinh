package com.example.baithicuoimodule3.quanlichothuenha.servlet;

import com.example.baithicuoimodule3.quanlichothuenha.dao.MatBangDAO;
import com.example.baithicuoimodule3.quanlichothuenha.model.MatBang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listMatBang")
public class ListMatBangServlet extends HttpServlet {
    private MatBangDAO matBangDAO;

    @Override
    public void init() {
        matBangDAO = new MatBangDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loaiMatBang = request.getParameter("loaiMatBang");
        String giaTienStr = request.getParameter("giaTien");
        String tangStr = request.getParameter("tang");

        Long giaTien = (giaTienStr != null && !giaTienStr.isEmpty()) ? Long.parseLong(giaTienStr) : null;
        Integer tang = (tangStr != null && !tangStr.isEmpty()) ? Integer.parseInt(tangStr) : null;

        List<MatBang> list;
        if ((loaiMatBang != null && !loaiMatBang.isEmpty()) || giaTien != null || tang != null) {
            list = matBangDAO.filter(loaiMatBang, giaTien, tang);
        } else {
            list = matBangDAO.getAll(); // luôn sắp xếp theo diện tích ASC
        }

        request.setAttribute("matBangList", list);
        request.getRequestDispatcher("/WEB-INF/listMatBang.jsp").forward(request, response);
    }
}
