package com.example.baithicuoimodule3.quanlichothuenha.dao;

import com.example.baithicuoimodule3.quanlichothuenha.model.MatBang;
import com.example.baithicuoimodule3.quanlichothuenha.service.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatBangDAO {

    public boolean insert(MatBang mb) {
        String sql = "INSERT INTO MatBang(MaMatBang, TrangThai, DienTich, Tang, LoaiMatBang, GiaTien, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mb.getMaMatBang());
            ps.setString(2, mb.getTrangThai());
            ps.setDouble(3, mb.getDienTich());
            ps.setInt(4, mb.getTang());
            ps.setString(5, mb.getLoaiMatBang());
            ps.setLong(6, mb.getGiaTien());
            ps.setDate(7, Date.valueOf(mb.getNgayBatDau()));
            ps.setDate(8, Date.valueOf(mb.getNgayKetThuc()));

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MatBang> getAll() {
        List<MatBang> list = new ArrayList<>();
        String sql = "SELECT * FROM MatBang ORDER BY DienTich ASC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                MatBang mb = new MatBang(
                        rs.getString("MaMatBang"),
                        rs.getString("TrangThai"),
                        rs.getDouble("DienTich"),
                        rs.getInt("Tang"),
                        rs.getString("LoaiMatBang"),
                        rs.getLong("GiaTien"),
                        rs.getDate("NgayBatDau").toLocalDate(),
                        rs.getDate("NgayKetThuc").toLocalDate()
                );
                list.add(mb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean exists(String maMatBang) {
        String sql = "SELECT COUNT(*) FROM MatBang WHERE MaMatBang=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maMatBang);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(String maMatBang) {
        String sql = "DELETE FROM MatBang WHERE MaMatBang = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maMatBang);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<MatBang> filter(String loaiMatBang, Long giaTien, Integer tang) {
        List<MatBang> list = new ArrayList<>();
        String sql = "SELECT * FROM MatBang WHERE 1=1";

        if (loaiMatBang != null && !loaiMatBang.isEmpty()) sql += " AND LoaiMatBang = ?";
        if (giaTien != null) sql += " AND GiaTien <= ?";
        if (tang != null) sql += " AND Tang = ?";

        sql += " ORDER BY DienTich ASC"; // Sắp xếp diện tích tăng dần

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int index = 1;
            if (loaiMatBang != null && !loaiMatBang.isEmpty()) ps.setString(index++, loaiMatBang);
            if (giaTien != null) ps.setLong(index++, giaTien);
            if (tang != null) ps.setInt(index++, tang);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MatBang mb = new MatBang(
                        rs.getString("MaMatBang"),
                        rs.getString("TrangThai"),
                        rs.getDouble("DienTich"),
                        rs.getInt("Tang"),
                        rs.getString("LoaiMatBang"),
                        rs.getLong("GiaTien"),
                        rs.getDate("NgayBatDau").toLocalDate(),
                        rs.getDate("NgayKetThuc").toLocalDate()
                );
                list.add(mb);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
