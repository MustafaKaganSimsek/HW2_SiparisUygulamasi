package org.example.service.impl;

import org.example.dto.Bill;
import org.example.dto.Company;
import org.example.dto.Customer;
import org.example.repository.Repo;
import org.example.repository.impl.BillRepo;
import org.example.repository.impl.CompanyRepo;
import org.example.service.CompanyService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private static int id = 1;
    private final Repo<Company> companyRepo;

    public CompanyServiceImpl() {
        this.companyRepo = new CompanyRepo();
    }
    @Override
    public Company save(Company company) {
        company.setId(id);
        id++;
        return companyRepo.save(company);
    }

    @Override
    public Company findById(Number id) {
        return companyRepo.findById(id);
    }

    @Override
    public Company addBill(Bill bill) {
        Company company = companyRepo.findById(bill.getCompanyId());
        List<Bill> bills = company.getBill();
        if (bills==null){
            bills = new LinkedList<Bill>();
        }
        bills.add(bill);
        company.setBill(bills);
        return companyRepo.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public List<Company> filterForUnderBillsNumber(int number) {
        return null;
    }
}
