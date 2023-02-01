package org.example.repository.impl;

import org.example.dto.Company;
import org.example.dto.Customer;
import org.example.repository.Repo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepo implements Repo<Customer> {
    private static HashMap<Number,Customer> data = new HashMap<>();

    @Override
    public Customer save(Customer customer) {
        return data.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(Number id) {
        return data.get(id);
    }

    @Override
    public List<Customer> findAll() {
        return data.values().stream().toList();
    }
}
