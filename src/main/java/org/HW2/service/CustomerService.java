package org.HW2.service;

import org.HW2.model.Customer;
import org.HW2.service.dto.CustomerDto;

import java.util.List;
import java.util.Set;

public interface CustomerService {
    CustomerDto save(Customer customer);



    List<CustomerDto> findByNameContains(String name);

    List<CustomerDto> findAllAsDto();

    List<Customer> findAll();

    Set<String> findNamesOfUnderBillAmount(int number);



    List<Customer> filterByMonth(int month);




}
