package org.example.service;

import org.example.model.Bill;
import org.example.model.Customer;
import org.example.service.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto save(Customer customer);

    CustomerDto findById(Number id);

    Customer addBill(Bill bill);

    List<CustomerDto> findByNameContains(String name);

    List<CustomerDto> findAllAsDto();

    List<Customer> findAll();


    List<Customer> filterByMonth(int month);




}
