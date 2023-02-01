package org.example.service.impl;

import org.example.model.Bill;
import org.example.model.Company;
import org.example.repository.Repo;
import org.example.repository.impl.CompanyRepo;
import org.example.service.AuditingService;
import org.example.service.CompanyService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CompanyServiceImpl implements CompanyService {

    private static int id = 1;
    private final Repo<Company> companyRepo;
    private final AuditingService auditingService;

    public CompanyServiceImpl() {
        this.auditingService = new AuditingService();
        this.companyRepo = new CompanyRepo();
    }
    @Override
    public Company save(Company company) {
        Company company1 = Company.builder()
                .name(company.getName())
                .sector(company.getSector())
                .date(auditingService.between())
                .id(id)
                .bill(new LinkedList<Bill>())
                .build();
        id++;
        return companyRepo.save(company1);
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
