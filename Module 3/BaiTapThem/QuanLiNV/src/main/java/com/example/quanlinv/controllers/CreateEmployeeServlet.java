package com.example.quanlinv.controllers;

import com.example.quanlinv.models.Department;
import com.example.quanlinv.models.Employee;
import com.example.quanlinv.services.DepartmentService;
import com.example.quanlinv.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/create-employee")
public class CreateEmployeeServlet extends HttpServlet {
    private final DepartmentService departmentService = new DepartmentService();
    private final EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departments = departmentService.getAll();
        req.setAttribute("departments", departments);
        req.getRequestDispatcher("/WEB-INF/form-employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String fullName = req.getParameter("full_name");
        String email    = req.getParameter("email");
        String phone    = req.getParameter("phone");
        String dept     = req.getParameter("department_id"); // "" hoặc số

        Integer deptId = (dept == null || dept.isBlank()) ? null : Integer.parseInt(dept);
        Employee e = new Employee(fullName, email, phone, deptId);
        employeeService.add(e);

        resp.sendRedirect(req.getContextPath() + "/employees");
    }
}
