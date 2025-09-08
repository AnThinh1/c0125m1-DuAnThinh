package com.example.duancuoikhoa.Model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product {
    private int id;
    private String name;
    private String category;
    private String brand;
    private String frameMaterial;
    private int year;
    private String size;
    private BigDecimal price;
    private int stockQuantity;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Product() {}

    public Product(int id, String name, String category, String brand, String frameMaterial, int year,
                   String size, BigDecimal price, int stockQuantity,
                   Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.frameMaterial = frameMaterial;
        this.year = year;
        this.size = size;
        this.price = price;
        this.stockQuantity = stockQuantity;

        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getFrameMaterial() { return frameMaterial; }
    public void setFrameMaterial(String frameMaterial) { this.frameMaterial = frameMaterial; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", frameMaterial='" + frameMaterial + '\'' +
                ", year=" + year +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
