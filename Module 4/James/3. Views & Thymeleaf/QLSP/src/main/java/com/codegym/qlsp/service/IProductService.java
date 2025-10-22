package com.codegym.qlsp.service;
import com.codegym.qlsp.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void remove(int id);
    void update(int id, Product product);
}


