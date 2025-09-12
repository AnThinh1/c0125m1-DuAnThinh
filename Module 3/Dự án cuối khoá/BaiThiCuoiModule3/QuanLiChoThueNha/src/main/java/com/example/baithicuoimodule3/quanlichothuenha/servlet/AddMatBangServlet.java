package com.example.baithicuoimodule3.quanlichothuenha.servlet;

import com.example.baithicuoimodule3.quanlichothuenha.dao.MatBangDAO;
import com.example.baithicuoimodule3.quanlichothuenha.model.MatBang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet("/addMatBang")
public class AddMatBangServlet extends HttpServlet {

    private MatBangDAO matBangDAO;

    @Override
    public void init() {
        matBangDAO = new MatBangDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addMatBang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String maMatBang = request.getParameter("maMatBang").toUpperCase();
        String trangThai = request.getParameter("trangThai");
        String loaiMatBang = request.getParameter("loaiMatBang");

        double dienTich = 0;
        int tang = 0;
        long giaTien = 0;
        LocalDate ngayBatDau = null;
        LocalDate ngayKetThuc = null;

        String errorMessage = null;

        if (matBangDAO.exists(maMatBang)) {
            errorMessage = "Mã mặt bằng đã tồn tại!";
        } else {
            try {
                dienTich = Double.parseDouble(request.getParameter("dienTich"));
                tang = Integer.parseInt(request.getParameter("tang"));
                giaTien = Long.parseLong(request.getParameter("giaTien"));
                ngayBatDau = LocalDate.parse(request.getParameter("ngayBatDau"));
                ngayKetThuc = LocalDate.parse(request.getParameter("ngayKetThuc"));
            } catch (NumberFormatException | DateTimeParseException e) {
                errorMessage = "Dữ liệu nhập không hợp lệ!";
            }
        }

        if (errorMessage != null) {
            request.setAttribute("error", errorMessage);
            request.setAttribute("maMatBang", maMatBang);
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("loaiMatBang", loaiMatBang);
            request.setAttribute("dienTich", request.getParameter("dienTich"));
            request.setAttribute("tang", request.getParameter("tang"));
            request.setAttribute("giaTien", request.getParameter("giaTien"));
            request.setAttribute("ngayBatDau", request.getParameter("ngayBatDau"));
            request.setAttribute("ngayKetThuc", request.getParameter("ngayKetThuc"));
            request.getRequestDispatcher("/WEB-INF/addMatBang.jsp").forward(request, response);
            return;
        }

        MatBang mb = new MatBang();
        mb.setMaMatBang(maMatBang);
        mb.setTrangThai(trangThai);
        mb.setLoaiMatBang(loaiMatBang);
        mb.setDienTich(dienTich);
        mb.setTang(tang);
        mb.setGiaTien(giaTien);
        mb.setNgayBatDau(ngayBatDau);
        mb.setNgayKetThuc(ngayKetThuc);

        matBangDAO.insert(mb);

        response.sendRedirect(request.getContextPath() + "/listMatBang");
    }
}
