package org.HW2.repository.impl;

import org.HW2.model.Customer;
import org.HW2.repository.Repo;

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
    public List<Customer> findAll() {
        return data.values().stream().toList();
    }
}
