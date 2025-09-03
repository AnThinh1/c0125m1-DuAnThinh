package com.codegym.thuchanh20250818.controllers;

import com.codegym.thuchanh20250818.models.Employee;
import com.codegym.thuchanh20250818.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class ListEmloyeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hiển thị toàn bộ nhân viên
        // Note: Không cần tới tham số đầu vào (query parameters)
        // Nếu cần tìm kiếm, thì mới dùng đến
        String q =  req.getParameter("q"); // q --> CSDL ("...WHERE name LIKE %a%) --> HTML
        String sortBy = req.getParameter("sortBy");

        // Thực thi SQL từ MySQL
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getAll(q, sortBy);

        // Hiển thị danh sách qua HTML
        // - Đưa list vào bộ nhớ (request)
        req.setAttribute("employees", employees);

        // - Chuyển qua JSP để hiển thị theo định dạng HTML
        req.getRequestDispatcher("/WEB-INF/list-employees.jsp").forward(req,resp);
    }
}
