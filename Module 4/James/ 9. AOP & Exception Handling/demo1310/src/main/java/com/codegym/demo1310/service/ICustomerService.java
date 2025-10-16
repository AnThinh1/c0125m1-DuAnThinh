package com.codegym.demo1310.service;

import com.codegym.demo1310.exception.DuplicateEmailException;
import com.codegym.demo1310.model.Customer;

public interface ICustomerService extends IGeneralService<Customer>{

    Iterable<Customer> findAllWithException() throws Exception;

    Customer saveWithException(Customer customer) throws Exception;

    Customer saveWithDuplicateEmailException(Customer customer) throws DuplicateEmailException;
}