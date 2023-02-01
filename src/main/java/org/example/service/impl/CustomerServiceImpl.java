package org.example.service.impl;

import org.example.model.Bill;
import org.example.model.Customer;
import org.example.repository.Repo;
import org.example.repository.impl.CustomerRepo;
import org.example.service.AuditingService;
import org.example.service.CustomerService;

import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static int id = 1;

    private final Repo<Customer> customerRepo;
    private final AuditingService auditingService;


    public CustomerServiceImpl() {
        this.auditingService = new AuditingService();
        this.customerRepo = new CustomerRepo();
    }


    @Override
    public Customer save(Customer customer) {
        Customer customer1 = Customer.builder()
                .id(id)
                .name(customer.getName())
                .surname(customer.getSurname())
                .bill(new LinkedList<Bill>())
                .date(auditingService.between())
                .build();
        id++;
        return customerRepo.save(customer1);
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
    public List<Customer> findByNameContains(String name) {
        return findAll().stream()
                .filter(customer -> customer.getName().contains(name))
                .toList();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public List<Customer> filterByMonth(int month) {
        return null;
    }
}
