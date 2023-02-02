package org.HW2.service.impl;

import org.HW2.model.Bill;
import org.HW2.model.Customer;
import org.HW2.repository.Repo;
import org.HW2.repository.impl.CustomerRepo;
import org.HW2.service.AuditingService;
import org.HW2.service.BillService;
import org.HW2.service.CustomerService;
import org.HW2.service.dto.CustomerDto;
import org.HW2.service.dto.converter.CustomerDtoConverter;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    private static int id = 1;

    private final Repo<Customer> customerRepo;
    private final AuditingService auditingService;
    private final CustomerDtoConverter customerDtoConverter;
    private final BillService billService;


    public CustomerServiceImpl() {
        this.customerDtoConverter = new CustomerDtoConverter();
        this.auditingService = new AuditingService();
        this.customerRepo = new CustomerRepo();
        this.billService =new BillServiceImpl();
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
    public Set<String> findNamesOfUnderBillAmount(int number) {
        return billService.filterByUnderBillAmount(500).stream().map(billDto -> billDto.getCustomer().getName() ).collect(Collectors.toSet());
    }

    @Override
    public List<Customer> filterByMonth(int month) {
        return null;
    }
}
