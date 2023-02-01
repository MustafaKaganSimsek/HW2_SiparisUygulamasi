package org.example.service;

import org.example.model.Bill;
import org.example.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    Customer findById(Number id);

    Customer addBill(Bill bill);

    List<Customer> findByNameContains(String name);

    List<Customer> findAll();

    List<Customer> filterByMonth(int month);




}
