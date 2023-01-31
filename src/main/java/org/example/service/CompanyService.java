package org.example.service;

import org.example.dto.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    List<Company> findAll();

    List<Company> filterForUnderBillsNumber(int number);
}
