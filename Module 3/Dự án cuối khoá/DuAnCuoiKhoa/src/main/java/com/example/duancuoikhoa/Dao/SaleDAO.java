package com.example.duancuoikhoa.Dao;

import com.example.duancuoikhoa.Model.Sale;
import com.example.duancuoikhoa.Service.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {


    public void insert(Sale sale) {
        String sql = "INSERT INTO sales_history (product_id, quantity, customer_name, customer_phone, sale_date) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, sale.getProductId());
            stmt.setInt(2, sale.getQuantity());
            stmt.setString(3, sale.getCustomerName());
            stmt.setString(4, sale.getCustomerPhone());
            // Nếu saleDate null -> set current time
            if (sale.getSaleDate() != null) {
                stmt.setTimestamp(5, Timestamp.valueOf(sale.getSaleDate()));
            } else {
                stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Sale> getAllSales() {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT s.id, s.product_id, s.quantity, s.customer_name, s.customer_phone, s.sale_date, " +
                "p.name AS product_name,p.price " +
                "FROM sales_history s " +
                "LEFT JOIN product p ON s.product_id = p.id " +
                "ORDER BY s.sale_date DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sale sale = new Sale(
                        rs.getInt("id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getString("customer_name"),
                        rs.getString("customer_phone"),
                        rs.getTimestamp("sale_date") != null ? rs.getTimestamp("sale_date").toLocalDateTime() : null
                );
                sale.setProductName(rs.getString("product_name"));
                sale.setPrice(rs.getDouble("price"));// có thể null nếu product bị xóa
                sales.add(sale);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sales;
    }
    public Sale findById(int id) {
        String sql = "SELECT s.id, s.product_id, s.quantity, s.customer_name, s.customer_phone, s.sale_date, " +
                "p.name AS product_name " +
                "FROM sales_history s " +
                "LEFT JOIN product p ON s.product_id = p.id " +
                "WHERE s.id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Sale sale = new Sale(
                            rs.getInt("id"),
                            rs.getInt("product_id"),
                            rs.getInt("quantity"),
                            rs.getString("customer_name"),
                            rs.getString("customer_phone"),
                            rs.getTimestamp("sale_date") != null ? rs.getTimestamp("sale_date").toLocalDateTime() : null
                    );
                    sale.setProductName(rs.getString("product_name"));
                    return sale;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void update(Sale sale) {
        String sql = "UPDATE sales_history SET product_id = ?, quantity = ?, customer_name = ?, customer_phone = ?, sale_date = ? " +
                "WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, sale.getProductId());
            stmt.setInt(2, sale.getQuantity());
            stmt.setString(3, sale.getCustomerName());
            stmt.setString(4, sale.getCustomerPhone());
            stmt.setTimestamp(5, sale.getSaleDate() != null ? Timestamp.valueOf(sale.getSaleDate()) : new Timestamp(System.currentTimeMillis()));
            stmt.setInt(6, sale.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id) {
        String sql = "DELETE FROM sales_history WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public double getTotalRevenue() {
        String sql = "SELECT SUM(s.quantity * p.price) AS revenue " +
                "FROM sales_history s " +
                "JOIN product p ON s.product_id = p.id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("revenue");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
