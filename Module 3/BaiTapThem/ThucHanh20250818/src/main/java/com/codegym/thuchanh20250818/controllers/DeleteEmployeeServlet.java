package com.codegym.thuchanh20250818.controllers;

import com.codegym.thuchanh20250818.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete-employee")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // INPUT: Lấy id từ URL để biết là cần phải xoá nhân viên nào
        String id = req.getParameter("id");

        // CSDL: Sửa EmployeeService --> bổ sung deleteById
        EmployeeService service = new EmployeeService();
        int result = service.deleteById(Integer.parseInt(id));

        // OUTPUT: Phản hồi kết qủa theo format HTML
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Delete Employee</title></head><body>");
        if (result > 0) {
            out.println("<h1>Đã xoá nhân viên có id=" + id + " thành công!</h1>");
        } else {
            out.println("<h1>Thao tác xoá thất bại!</h1>");
        }

        out.println("</body></html>");
    }
}
