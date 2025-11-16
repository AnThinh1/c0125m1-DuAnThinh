package com.codegym.commencalstore.service;

import com.codegym.commencalstore.model.Bike;
import java.util.List;

public interface BikeService {
    List<Bike> findAll();
    Bike findById(Long id);
    Bike save(Bike bike);
    void delete(Long id);
    List<Bike> filterAndSort(String category, String sortOrder);
}