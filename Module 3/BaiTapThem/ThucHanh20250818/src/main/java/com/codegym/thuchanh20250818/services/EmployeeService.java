package com.codegym.thuchanh20250818.services;

import com.codegym.thuchanh20250818.libs.DBConnection;
import com.codegym.thuchanh20250818.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    DBConnection dbConnection = new DBConnection();

    public void add(Employee employee) {
        // SQL (INSERT INTO)
        String SQL = "INSERT INTO employees (full_name, phone, email, department_id) VALUES (?, ?, ?, ?)";
        // full_name VARCHAR(100) --> String
        // Đảm bảo có kết nối dbConnection.getConnection() --> Connection

        // PreparedStatement --> thực thi câu lệnh SQL
        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
             ) {

            statement.setString(1, employee.getFullName());
            statement.setString(2, employee.getPhone());
            statement.setString(3, employee.getEmail());
            if (employee.getDepartmentId() == 0) {
                statement.setNull(4, java.sql.Types.INTEGER);
            } else {
                statement.setInt(4, employee.getDepartmentId());
            }


            statement.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Employee employee) {
        // SQL (INSERT INTO)
        String SQL = "UPDATE employees SET full_name = ?, phone = ?, email = ? WHERE id = ?";
        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
        ) {
            statement.setString(1, employee.getFullName());
            statement.setString(2, employee.getPhone());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Sửa lại phương thức: bổ sung thêm tham số q
    public List<Employee> getAll(String q, String sortBy) {
        List<Employee> employees = new ArrayList<>();
        String SQL = "SELECT e.id, e.full_name, e.email, e.phone, e.department_id, d.name AS department_name FROM employees e LEFT JOIN departments d ON e.department_id = d.id";

        if (q != null && !q.isEmpty()) {
            SQL = SQL + " WHERE full_name LIKE '%" + q + "%' OR email LIKE '%" + q + "%'";
        }

        if (sortBy != null && !sortBy.isEmpty()) {
            SQL = SQL + " ORDER BY " + sortBy;
        }

        // try-with-resources
        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
                ) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");

                Employee employee = new Employee(id, fullName, email, phone, departmentId, departmentName);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public Employee getById(int id) {
        String SQL = "SELECT * FROM employees WHERE id = ?";
        // try-with-resources
        try (
            Connection conn = dbConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                int currentId = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                Employee employee = new Employee(currentId, fullName, email, phone);
                return  employee;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public int deleteById(int id) {
        String SQL = "DELETE FROM employees WHERE id = ?";
        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
                ) {
            statement.setInt(1, id);
            int result = statement.executeUpdate(); // số row bị ảnh hưởng.
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
