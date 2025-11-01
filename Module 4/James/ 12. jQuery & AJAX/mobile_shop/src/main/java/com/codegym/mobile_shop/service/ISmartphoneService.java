package com.codegym.mobile_shop.service;

import com.codegym.mobile_shop.model.Smartphone;
import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();
    Optional<Smartphone> findById(Long id);
    Smartphone save(Smartphone smartphone);
    void remove(Long id);
}
