package org.example.service.impl;

import org.example.model.Bill;
import org.example.model.Company;
import org.example.repository.Repo;
import org.example.repository.impl.CompanyRepo;
import org.example.service.AuditingService;
import org.example.service.BillService;
import org.example.service.CompanyService;
import org.example.service.dto.CompanyDto;
import org.example.service.dto.converter.CompanyDtoConverter;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CompanyServiceImpl implements CompanyService {

    private static int id = 1;
    private final Repo<Company> companyRepo;
    private final AuditingService auditingService;
    private final CompanyDtoConverter companyDtoConverter;
    private final BillService billService;


    public CompanyServiceImpl() {
        this.companyDtoConverter = new CompanyDtoConverter();
        this.auditingService = new AuditingService();
        this.companyRepo = new CompanyRepo();
        this.billService =new BillServiceImpl();
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
    public List<CompanyDto> findAllAsDto() {
        return companyDtoConverter.convert(companyRepo.findAll());
    }

    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public Set<String> findSectorsOfUnderBillAmount(int number) {
        List<Company> companies = companyRepo.findAll().stream()
                .filter(
                        company -> company.getBill().stream()
                                .mapToDouble(bill->bill.getPrice())
                                .average().getAsDouble()<number)
                .toList();
        return companies.stream().map(company -> company.getSector()).collect(Collectors.toSet());
    }


}
