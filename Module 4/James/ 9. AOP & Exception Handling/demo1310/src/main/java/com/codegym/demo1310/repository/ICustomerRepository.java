package com.codegym.demo1310.repository;

import com.codegym.demo1310.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {
}
