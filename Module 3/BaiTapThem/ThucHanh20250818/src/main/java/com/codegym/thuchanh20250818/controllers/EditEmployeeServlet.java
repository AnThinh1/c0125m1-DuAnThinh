package com.codegym.thuchanh20250818.controllers;

import com.codegym.thuchanh20250818.models.Employee;
import com.codegym.thuchanh20250818.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit-employee")
public class EditEmployeeServlet extends HttpServlet {

    // Hiển thị form để người dùng nhập liệu (form-employee.jsp)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        // Lấy dữ liệu cũ của nhân viên có id đầu vào trên URL
        EmployeeService service = new EmployeeService();
        Employee employee = service.getById(Integer.parseInt(id));

        // Context của request
        req.setAttribute("employee", employee);

        // forward
        req.getRequestDispatcher("/WEB-INF/form-employee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // thực hiện thao tác chỉnh sửa vào CSDL.

        // Query parameter (URL)
        String  id = req.getParameter("id");

        // Form (input) --> Payload
        String  fullName = req.getParameter("full_name");
        String  phone = req.getParameter("phone");
        String  email = req.getParameter("email");

        // Lưu dữ liệu mới vào CSDL (UPDATE)
        Employee employee = new Employee(Integer.parseInt(id), fullName, email, phone);
        EmployeeService service = new EmployeeService();
        service.update(employee);

        // Phản hồi thông tin cho người dùng
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Đã cập nhật thông tin nhân viên thành công!<br/>");
        out.println("<a href=\"./employees\">Trở về Danh sách Nhân viên</a>");
    }
}
