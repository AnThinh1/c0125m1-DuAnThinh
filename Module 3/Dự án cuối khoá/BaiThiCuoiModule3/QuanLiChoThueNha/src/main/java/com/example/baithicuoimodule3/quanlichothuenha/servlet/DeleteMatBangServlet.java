package com.example.baithicuoimodule3.quanlichothuenha.servlet;

import com.example.baithicuoimodule3.quanlichothuenha.dao.MatBangDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteMatBang")
public class DeleteMatBangServlet extends HttpServlet {
    private MatBangDAO matBangDAO = new MatBangDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maMatBang = request.getParameter("maMatBang");
        if (maMatBang != null && !maMatBang.isEmpty()) {
            matBangDAO.delete(maMatBang);
        }
        response.sendRedirect(request.getContextPath() + "/listMatBang");
    }
}
