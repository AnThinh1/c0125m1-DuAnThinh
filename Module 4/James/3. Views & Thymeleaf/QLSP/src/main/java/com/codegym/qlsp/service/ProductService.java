package com.codegym.qlsp.service;

import com.codegym.qlsp.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Xiaomi",10000000, "Dien thoai","Xiaomi"));
        products.put(2, new Product(2, "Iphone",10000000, "Dien thoai","Apple"));
        products.put(3, new Product(3, "Oppo",10000000, "Dien thoai","Oppo"));
        products.put(4, new Product(4, "Huawei",10000000, "Dien thoai","Huawei"));
        products.put(5, new Product(5, "Samsung",10000000, "Dien thoai","Samsung"));
        products.put(6, new Product(6, "Vivo",10000000, "Dien thoai","Vivo"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
