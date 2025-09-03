package com.example.tuluyen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    DBConnection dbConnection = new DBConnection();

    public void add(Employee employee) {
        String SQL = "INSERT INTO employees (fullname, email, phone, department, salary, hiredate) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {

            statement.setString(1, employee.getFullName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getDepartment());
            statement.setDouble(5, employee.getSalary());
            statement.setDate(6, Date.valueOf(employee.getHireDate()));

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAll(String q) {
        List<Employee> employees = new ArrayList<>();
        String SQL = "SELECT * FROM employees";

        if (q!= null && !q.isEmpty()) {
            SQL = SQL + " WHERE fullname LIKE '%" + q + "%' OR email LIKE '%" + q + "%'";
        }

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname  = rs.getString("fullname");
                String phone     = rs.getString("phone");
                String email     = rs.getString("email");
                String department= rs.getString("department");
                String hiredate  = rs.getString("hiredate");
                double salary    = rs.getDouble("salary");

                Employee employee = new Employee(id,fullname, email, phone, department, salary, hiredate);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public void deleteById(int id) {
        String SQL = "DELETE FROM employees WHERE id = ?";
        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
                ) {
        statement.setInt(1,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
