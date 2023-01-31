package org.example.service;

import org.example.dto.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    List<Customer> findAll();

    List<Customer> findByNameContaining(String customerName);

    List<Customer> filterByMonth(int month);



}
