package com.codegym.springbootproductmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private BigDecimal productPrice;
    private String productDescription;
    private String productBrand;


 @Override
    public String toString() {
     return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice + ", productDescription=" + productDescription + ", productBrand=" + productBrand + "]";
 }
}