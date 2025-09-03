package com.codegym.thuchanh20250818.services;

import com.codegym.thuchanh20250818.libs.DBConnection;
import com.codegym.thuchanh20250818.models.Department;
import com.codegym.thuchanh20250818.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    DBConnection dbConnection = new DBConnection();

    public List<Department> getAll() {
        String SQL = "SELECT * FROM departments";
        List<Department> departments = new ArrayList<>();
        try (
                Connection conn = dbConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SQL);
        ) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                Department  department = new Department(id, name, description);
                departments.add(department);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

}
