package com.example.duancuoikhoa.Dao;

import com.example.duancuoikhoa.Model.Product;
import com.example.duancuoikhoa.Service.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void insert(Product product) {
        String sql = "INSERT INTO product (name, category, brand, frame_material, year, size, price, stock_quantity, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getCategory());
            stmt.setString(3, product.getBrand());
            stmt.setString(4, product.getFrameMaterial());
            stmt.setInt(5, product.getYear());
            stmt.setString(6, product.getSize());
            stmt.setBigDecimal(7, product.getPrice());
            stmt.setInt(8, product.getStockQuantity());
            stmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE category = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getString("brand"),
                        rs.getString("frame_material"),
                        rs.getInt("year"),
                        rs.getString("size"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock_quantity"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }


    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getString("brand"),
                        rs.getString("frame_material"),
                        rs.getInt("year"),
                        rs.getString("size"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock_quantity"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public void update(Product product) {
        String sql = "UPDATE product SET name=?, category=?, brand=?, frame_material=?, year=?, size=?, price=?, stock_quantity=?, updated_at=NOW() WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getCategory());
            stmt.setString(3, product.getBrand());
            stmt.setString(4, product.getFrameMaterial());
            stmt.setInt(5, product.getYear());
            stmt.setString(6, product.getSize());
            stmt.setBigDecimal(7, product.getPrice());
            stmt.setInt(8, product.getStockQuantity());
            stmt.setInt(9, product.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM product WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getString("brand"),
                        rs.getString("frame_material"),
                        rs.getInt("year"),
                        rs.getString("size"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock_quantity"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

