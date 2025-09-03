package com.example.tuluyen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "123456");
            return conn;
        } catch (ClassNotFoundException e ) {
            throw new RuntimeException(e);
        } catch (SQLException e ) {
            throw new RuntimeException(e);
        }
    }
}