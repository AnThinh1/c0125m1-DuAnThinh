package com.codegym.thuchanh20250818.controllers;

import com.codegym.thuchanh20250818.models.Department;
import com.codegym.thuchanh20250818.models.Employee;
import com.codegym.thuchanh20250818.services.DepartmentService;
import com.codegym.thuchanh20250818.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/create-employee")
public class CreateEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy danh sách phòng ban từ CSDL
        DepartmentService service = new DepartmentService();
        List<Department> departmentList = service.getAll();

        // Gán vào bộ nhớ request (context request)
        req.setAttribute("departments", departmentList);

        // Forward sang form
        req.getRequestDispatcher("/WEB-INF/form-employee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xử lý input do người nhập và submit lên
        String fullName = req.getParameter("full_name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String department = req.getParameter("department");

        Employee employee;
        // "" --> chưa chọn phòng ban.
        if (department == null || department.equals("")) {
            employee = new Employee(fullName, email, phone);
        } else { // 1, 2,.... --> người dùng đã chọn
            employee = new Employee(fullName, email, phone, Integer.parseInt(department));
        }

        // Lưu vào DB
        EmployeeService employeeService = new EmployeeService();
        employeeService.add(employee);

        // Phản hồi kết quả
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Đã thêm nhân viên thành công");
    }
}
