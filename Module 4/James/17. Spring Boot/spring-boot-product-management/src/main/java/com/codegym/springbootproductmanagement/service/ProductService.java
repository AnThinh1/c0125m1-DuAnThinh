package com.codegym.springbootproductmanagement.service;

import com.codegym.springbootproductmanagement.model.Product;
import com.codegym.springbootproductmanagement.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product customer) {
        iProductRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        iProductRepository.deleteById(id);
    }
}