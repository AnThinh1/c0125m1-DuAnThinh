package com.codegym.cinema.service;

import com.codegym.cinema.model.Promotion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionService {

    List<Promotion> findAll();

    Optional<Promotion> findById(Long id);

    void save(Promotion promotion);

    void deleteById(Long id);

    List<Promotion> search(Long discount, LocalDate startDate, LocalDate endDate);
}
