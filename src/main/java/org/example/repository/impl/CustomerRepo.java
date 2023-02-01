package org.example.repository.impl;

import org.example.model.Customer;
import org.example.repository.Repo;

import java.util.HashMap;
import java.util.List;

public class CustomerRepo implements Repo<Customer> {
    protected static HashMap<Number,Customer> data = new HashMap<>();

    @Override
    public Customer save(Customer customer) {
        data.put(customer.getId(),customer);
        return data.get(customer.getId());
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
