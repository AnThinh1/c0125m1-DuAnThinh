package com.example.quanlinv.services;

import com.example.quanlinv.libs.DBConnection;
import com.example.quanlinv.models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    private final DBConnection db = new DBConnection();

    public List<Department> getAll() {
        String SQL = "SELECT id, name, description FROM departments";
        List<Department> departments = new ArrayList<>();
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                departments.add(new Department(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }
}
