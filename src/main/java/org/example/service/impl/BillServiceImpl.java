package org.example.service.impl;

import org.example.dto.Bill;
import org.example.dto.Order;
import org.example.repository.Repo;
import org.example.repository.impl.BillRepo;
import org.example.service.BillService;

import java.util.List;

public class BillServiceImpl implements BillService {


    private final Repo<Bill> billRepo;

    public BillServiceImpl() {
        this.billRepo = new BillRepo();
    }

    @Override
    public Bill save(Order order) {
        Bill bill = Bill.builder()
                .price(order.getPrice())
                .customerId(order.getCustomerId())
                .companyId(order.getCompanyId())
                .build();
        return billRepo.save(bill);
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
