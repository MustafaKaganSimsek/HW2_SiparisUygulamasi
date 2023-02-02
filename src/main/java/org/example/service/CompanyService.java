package org.example.service;

import org.example.model.Company;
import org.example.service.dto.CompanyDto;

import java.util.List;
import java.util.Set;

public interface CompanyService {
    CompanyDto save(Company company);

    List<CompanyDto> findAllAsDto();

    List<Company> findAll();

    Set<String> findSectorsOfUnderBillAmount(int number);


}
