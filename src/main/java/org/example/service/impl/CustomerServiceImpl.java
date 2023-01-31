package org.example.service.impl;

import org.example.dto.Customer;
import org.example.repository.Repo;
import org.example.repository.impl.CustomerRepo;
import org.example.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final Repo<Customer> customerRepo;

    public CustomerServiceImpl() {
        this.customerRepo = new CustomerRepo();
    }


    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public List<Customer> findByNameContaining(String customerName) {
        return null;
    }

    @Override
    public List<Customer> filterByMonth(int month) {
        return null;
    }
}
