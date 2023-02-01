package org.example.service;

import org.example.model.Bill;
import org.example.model.Company;
import org.example.service.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto save(Company company);

    CompanyDto findById(Number id);

    CompanyDto addBill(Bill bill);

    List<CompanyDto> findAllAsDto();

    List<Company> findAll();


    List<Company> filterForUnderBillsNumber(int number);
}
