package com.codegym.commencalstore.repository;
import com.codegym.commencalstore.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
    List<Bike> findByCategory(String category);
    List<Bike> findAllByOrderByPriceAsc();
    List<Bike> findAllByOrderByPriceDesc();
    List<Bike> findByCategoryOrderByPriceAsc(String category);
    List<Bike> findByCategoryOrderByPriceDesc(String category);
}
