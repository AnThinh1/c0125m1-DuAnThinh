package com.example.tuluyen;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        String id= req.getParameter("id");
        out.println("<html><head><title>Delete Employee</title></head><body>");
        out.println("<h1>Deleted Employee id="+id+"!</h1>");
        out.println("<body></html>");
    }
}
