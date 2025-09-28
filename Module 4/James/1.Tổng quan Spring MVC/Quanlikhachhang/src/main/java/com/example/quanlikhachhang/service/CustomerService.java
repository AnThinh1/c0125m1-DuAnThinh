package com.example.quanlikhachhang.service;

import com.example.quanlikhachhang.model.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
}
