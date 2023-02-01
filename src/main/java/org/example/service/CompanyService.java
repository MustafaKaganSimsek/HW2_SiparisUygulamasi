package org.example.service;

import org.example.dto.Bill;
import org.example.dto.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    Company findById(Number id);

    Company addBill(Bill bill);

    List<Company> findAll();

    List<Company> filterForUnderBillsNumber(int number);
}
