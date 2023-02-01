package org.example.service.impl;

import org.example.dto.Bill;
import org.example.dto.Customer;
import org.example.repository.Repo;
import org.example.repository.impl.CustomerRepo;
import org.example.service.CustomerService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static int id = 1;

    private final Repo<Customer> customerRepo;

    public CustomerServiceImpl() {
        this.customerRepo = new CustomerRepo();
    }


    @Override
    public Customer save(Customer customer) {
        customer.setId(id);
        id++;
        return customerRepo.save(customer);
    }

    @Override
    public Customer findById(Number id) {
        return customerRepo.findById(id);
    }

    @Override
    public Customer addBill(Bill bill) {
        Customer customer = customerRepo.findById(bill.getCustomerId());
        List<Bill> bills = customer.getBill();
        if (bills==null){
            bills = new LinkedList<Bill>();
        }
            bills.add(bill);
            customer.setBill(bills);
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
