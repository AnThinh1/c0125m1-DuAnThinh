package com.codegym.commencalstore.service;

import com.codegym.commencalstore.model.Bike;
import com.codegym.commencalstore.repository.BikeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    public BikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }

    @Override
    public Bike findById(Long id) {
        return bikeRepository.findById(id).orElse(null);
    }

    @Override
    public Bike save(Bike bike) {
        return bikeRepository.save(bike);
    }

    @Override
    public void delete(Long id) {
        bikeRepository.deleteById(id);
    }

    @Override
    public List<Bike> filterAndSort(String category, String sortOrder) {
        if ((category == null || category.isEmpty()) && (sortOrder == null || sortOrder.isEmpty())) {
            return bikeRepository.findAll();
        }

        if (category == null || category.isEmpty()) {
            // chỉ sort
            if ("asc".equals(sortOrder)) return bikeRepository.findAllByOrderByPriceAsc();
            else if ("desc".equals(sortOrder)) return bikeRepository.findAllByOrderByPriceDesc();
            else return bikeRepository.findAll();
        }

        // có category
        if ("asc".equals(sortOrder)) return bikeRepository.findByCategoryOrderByPriceAsc(category);
        else if ("desc".equals(sortOrder)) return bikeRepository.findByCategoryOrderByPriceDesc(category);
        else return bikeRepository.findByCategory(category);
    }
}

