
package com.codegym.demo1310.service.impl;

import com.codegym.demo1310.exception.DuplicateEmailException;
import com.codegym.demo1310.model.Customer;
import com.codegym.demo1310.repository.ICustomerRepository;
import com.codegym.demo1310.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Iterable<Customer> findAll(){
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllWithException() throws Exception {
        if(true) throw new Exception("a dummy exception");
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer saveWithException(Customer customer) throws Exception {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Customer saveWithDuplicateEmailException(Customer customer) throws DuplicateEmailException {
        try {
            return iCustomerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }
}
