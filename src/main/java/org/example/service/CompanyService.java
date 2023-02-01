package org.example.service;

import org.example.model.Bill;
import org.example.model.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    Company findById(Number id);

    Company addBill(Bill bill);

    List<Company> findAll();

    List<Company> filterForUnderBillsNumber(int number);
}
