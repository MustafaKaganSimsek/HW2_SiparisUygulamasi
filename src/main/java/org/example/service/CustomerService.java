package org.example.service;

import org.example.dto.Bill;
import org.example.dto.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    Customer findById(Number id);

    Customer addBill(Bill bill);

    List<Customer> findAll();

    List<Customer> findByNameContaining(String customerName);

    List<Customer> filterByMonth(int month);




}
