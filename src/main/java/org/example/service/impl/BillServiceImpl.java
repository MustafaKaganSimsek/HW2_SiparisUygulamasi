package org.example.service.impl;

import org.example.dto.Bill;
import org.example.dto.Order;
import org.example.repository.Repo;
import org.example.repository.impl.BillRepo;
import org.example.service.BillService;
import org.example.service.CompanyService;
import org.example.service.CustomerService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BillServiceImpl implements BillService {

    private static int id=1;

    private final Repo<Bill> billRepo;
    private final CustomerService customerService;
    private final CompanyService companyService;

    public BillServiceImpl() {
        this.customerService = new CustomerServiceImpl();
        this.companyService = new CompanyServiceImpl();
        this.billRepo = new BillRepo();
    }

    @Override
    public Bill save(Order order) {
        if (order==null){
            return null;
        }else {
            Bill bill = Bill.builder()
                    .id(id)
                    .price(order.getPrice())
                    .customerId(order.getCustomerId())
                    .companyId(order.getCompanyId())
                    .date(AuditingService.between())
                    .build();
            companyService.addBill(bill);
            customerService.addBill(bill);
            id++;
            return billRepo.save(bill);
        }
    }

    @Override
    public List<Bill> findAll() {
        return billRepo.findAll();

    }

    @Override
    public List<Bill> filterByUnderBillAmount(int number) {

        return billRepo.findAll().stream()
                .filter(bill -> bill.getPrice()<number)
                .toList();
    }

    @Override
    public List<Bill> filterByUpperBillAmount(int number) {

        return billRepo.findAll().stream()
                .filter(bill -> bill.getPrice()>number)
                .toList();
    }





}
