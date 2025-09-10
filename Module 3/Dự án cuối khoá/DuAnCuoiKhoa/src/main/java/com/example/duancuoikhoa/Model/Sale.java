package com.example.duancuoikhoa.Model;

import java.time.LocalDateTime;

public class Sale {
    private int id;
    private int productId;
    private int quantity;
    private String customerName;
    private String customerPhone;
    private LocalDateTime saleDate;
    private String productName;
    private double price;

    public Sale() {}

    public Sale(int id, int productId, int quantity, String customerName, String customerPhone, LocalDateTime saleDate) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.saleDate = saleDate;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
