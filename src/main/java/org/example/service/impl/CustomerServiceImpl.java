package org.example.service.impl;

import org.example.model.Bill;
import org.example.model.Customer;
import org.example.repository.Repo;
import org.example.repository.impl.CustomerRepo;
import org.example.service.AuditingService;
import org.example.service.CustomerService;
import org.example.service.dto.CustomerDto;
import org.example.service.dto.converter.CustomerDtoConverter;

import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static int id = 1;

    private final Repo<Customer> customerRepo;
    private final AuditingService auditingService;
    private final CustomerDtoConverter customerDtoConverter;


    public CustomerServiceImpl() {
        this.customerDtoConverter = new CustomerDtoConverter();
        this.auditingService = new AuditingService();
        this.customerRepo = new CustomerRepo();
    }


    @Override
    public CustomerDto save(Customer customer) {
        Customer customer1 = Customer.builder()
                .id(id)
                .name(customer.getName())
                .surname(customer.getSurname())
                .bill(new LinkedList<Bill>())
                .date(auditingService.between())
                .build();
        id++;
        Customer customer2 = customerRepo.save(customer1);
        return customerDtoConverter.convert(customer2);
    }

    @Override
    public CustomerDto findById(Number id) {
        return customerDtoConverter.convert(customerRepo.findById(id));
    }

    @Override
    public Customer addBill(Bill bill) {
        Customer customer = customerRepo.findById(bill.getCustomer().getId());
        List<Bill> bills = customer.getBill();
        if (bills==null){
            bills = new LinkedList<Bill>();
        }
            bills.add(bill);
            customer.setBill(bills);
        return customerRepo.save(customer);
    }

    @Override
    public List<CustomerDto> findByNameContains(String name) {
        List<Customer> customers = customerRepo.findAll().stream()
                .filter(customer -> customer.getName().contains(name))
                .toList();

        return customerDtoConverter.convert(customers);
    }

    @Override
    public List<CustomerDto> findAllAsDto() {
        return customerDtoConverter.convert(customerRepo.findAll());
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
