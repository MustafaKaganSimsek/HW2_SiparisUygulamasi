package org.HW2.service;

import org.HW2.model.Company;
import org.HW2.service.dto.CompanyDto;

import java.util.List;
import java.util.Set;

public interface CompanyService {
    CompanyDto save(Company company);

    List<CompanyDto> findAllAsDto();

    List<Company> findAll();

    Set<String> findSectorsOfUnderBillAmount(int number);


}
