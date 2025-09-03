package com.example.tuluyen;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class ListEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String q = req.getParameter("q");
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getAll(q);
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/WEB-INF/list-employee.jsp").forward(req, resp);
    }
}
