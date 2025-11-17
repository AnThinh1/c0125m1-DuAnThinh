package com.codegym.cinema.service;

import com.codegym.cinema.model.Promotion;
import com.codegym.cinema.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository repo;

    @Override
    public List<Promotion> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void save(Promotion promotion) {
        repo.save(promotion);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Promotion> search(Long discount, LocalDate startDate, LocalDate endDate) {
        return repo.searchByDiscountAndDateRange(discount, startDate, endDate);
    }
}
