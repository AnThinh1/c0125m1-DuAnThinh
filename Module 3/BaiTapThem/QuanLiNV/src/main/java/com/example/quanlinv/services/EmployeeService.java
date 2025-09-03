package com.example.quanlinv.services;

import com.example.quanlinv.libs.DBConnection;
import com.example.quanlinv.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private final DBConnection db = new DBConnection();

    public void add(Employee employee) {
        String SQL = "INSERT INTO employees(full_name, phone, email, department_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, employee.getFullName());
            ps.setString(2, employee.getPhone());
            ps.setString(3, employee.getEmail());
            if (employee.getDepartmentId() == null || employee.getDepartmentId() == 0) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, employee.getDepartmentId());
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Employee employee) {
        String SQL = "UPDATE employees SET full_name = ?, phone = ?, email = ?, department_id = ? WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, employee.getFullName());
            ps.setString(2, employee.getPhone());
            ps.setString(3, employee.getEmail());
            if (employee.getDepartmentId() == null || employee.getDepartmentId() == 0) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, employee.getDepartmentId());
            }
            ps.setInt(5, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // q: tìm theo tên hoặc email; sortBy: whitelist cột cho ORDER BY
    public List<Employee> getAll(String q, String sortBy) {
        List<Employee> employees = new ArrayList<>();

        String base = """
            SELECT e.id, e.full_name, e.email, e.phone,
                   e.department_id, d.name AS department_name
            FROM employees e
            LEFT JOIN departments d ON e.department_id = d.id
            """;

        StringBuilder SQL = new StringBuilder(base);
        List<Object> params = new ArrayList<>();

        if (q != null && !q.isEmpty()) {
            SQL.append(" WHERE e.full_name LIKE ? OR e.email LIKE ?");
            params.add("%" + q + "%");
            params.add("%" + q + "%");
        }

        // whitelist sort
        String orderBy = null;
        if ("name".equalsIgnoreCase(sortBy))        orderBy = "e.full_name ASC";
        else if ("email".equalsIgnoreCase(sortBy))  orderBy = "e.email ASC";
        else if ("dept".equalsIgnoreCase(sortBy))   orderBy = "d.name ASC";
        if (orderBy != null) SQL.append(" ORDER BY ").append(orderBy);

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL.toString())) {

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    employees.add(new Employee(
                            rs.getInt("id"),
                            rs.getString("full_name"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            (Integer) rs.getObject("department_id"),
                            rs.getString("department_name")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public Employee getById(int id) {
        String SQL = """
            SELECT e.id, e.full_name, e.email, e.phone, e.department_id
            FROM employees e WHERE e.id = ?
            """;
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("full_name"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            (Integer) rs.getObject("department_id"),
                            null
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int deleteById(int id) {
        String SQL = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
