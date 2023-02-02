package org.example.repository.impl;

import org.example.model.Bill;
import org.example.model.Company;
import org.example.model.Customer;
import org.example.repository.Repo;
import org.example.service.dto.CompanyDto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BillRepo implements Repo<Bill> {

    private static HashMap<Number,Bill> data = new HashMap<>();

    @Override
    public Bill save(Bill bill) {
        Company company = getCompanyForBill(bill);
        Customer customer = getCustomerorBill(bill);
        CompanyRepo.data.put(bill.getCompany().getId(),company);
        CustomerRepo.data.put(bill.getCustomer().getId(),customer);
        data.put(bill.getId(), bill);
        return data.get(bill.getId());

    }


    @Override
    public List<Bill> findAll() {
            return data.values().stream().toList();
    }

    private Company getCompanyForBill(Bill bill) {
        Company company = CompanyRepo.data.get(bill.getCompany().getId());
        List<Bill> bills = company.getBill();
        if (bills==null){
            bills = new LinkedList<Bill>();
        }
        bills.add(bill);
        company.setBill(bills);
        return company;
    }

    private Customer getCustomerorBill(Bill bill) {
        Customer customer = CustomerRepo.data.get(bill.getCustomer().getId());
        List<Bill> bills = customer.getBill();
        if (bills==null){
            bills = new LinkedList<Bill>();
        }
        bills.add(bill);
        customer.setBill(bills);
        return customer;
    }

}
