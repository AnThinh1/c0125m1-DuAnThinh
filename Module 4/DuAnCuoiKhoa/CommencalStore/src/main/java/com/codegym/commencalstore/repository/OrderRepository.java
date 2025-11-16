package com.codegym.commencalstore.repository;

import com.codegym.commencalstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}