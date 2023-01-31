package org.example.repository.impl;

import org.example.dto.Company;
import org.example.dto.Customer;
import org.example.repository.Repo;

import java.util.LinkedList;
import java.util.List;

public class CustomerRepo implements Repo<Customer> {
    private static LinkedList<Customer> data = new LinkedList<>();

    @Override
    public Customer save(Customer customer) {
        return ((customer != null) ? data.add(customer) : false) ? customer : null;
    }

    @Override
    public List<Customer> findAll() {
        return data.stream().toList();
    }
}
