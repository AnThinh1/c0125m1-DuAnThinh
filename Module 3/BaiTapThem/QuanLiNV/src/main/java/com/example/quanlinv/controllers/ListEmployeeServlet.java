package com.example.quanlinv.controllers;

import com.example.quanlinv.models.Employee;
import com.example.quanlinv.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class ListEmployeeServlet extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        String sort = req.getParameter("sort"); // name | email | dept
        List<Employee> employees = employeeService.getAll(q, sort);
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/WEB-INF/list-employee.jsp").forward(req, resp);
    }
}
