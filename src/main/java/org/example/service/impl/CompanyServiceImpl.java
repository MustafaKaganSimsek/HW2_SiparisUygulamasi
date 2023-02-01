package org.example.service.impl;

import org.example.model.Bill;
import org.example.model.Company;
import org.example.repository.Repo;
import org.example.repository.impl.CompanyRepo;
import org.example.service.AuditingService;
import org.example.service.CompanyService;
import org.example.service.dto.CompanyDto;
import org.example.service.dto.converter.CompanyDtoConverter;

import java.util.LinkedList;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private static int id = 1;
    private final Repo<Company> companyRepo;
    private final AuditingService auditingService;
    private final CompanyDtoConverter companyDtoConverter;

    public CompanyServiceImpl() {
        this.companyDtoConverter = new CompanyDtoConverter();
        this.auditingService = new AuditingService();
        this.companyRepo = new CompanyRepo();
    }
    @Override
    public CompanyDto save(Company company) {
        Company company1 = Company.builder()
                .name(company.getName())
                .sector(company.getSector())
                .date(auditingService.between())
                .id(id)
                .bill(new LinkedList<Bill>())
                .build();
        id++;
        return companyDtoConverter.convert(companyRepo.save(company1));
    }

    @Override
    public CompanyDto findById(Number id) {
        return companyDtoConverter.convert(companyRepo.findById(id));
    }

    @Override
    public CompanyDto addBill(Bill bill) {
        Company company = companyRepo.findById(bill.getCompany().getId());
        List<Bill> bills = company.getBill();
        if (bills==null){
            bills = new LinkedList<Bill>();
        }
        bills.add(bill);
        company.setBill(bills);
        return companyDtoConverter.convert(companyRepo.save(company));
    }

    @Override
    public List<CompanyDto> findAllAsDto() {
        return companyDtoConverter.convert(companyRepo.findAll());
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
