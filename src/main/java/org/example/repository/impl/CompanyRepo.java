package org.example.repository.impl;

import org.example.dto.Bill;
import org.example.dto.Company;
import org.example.repository.Repo;

import java.util.LinkedList;
import java.util.List;

public class CompanyRepo implements Repo<Company> {

    private static LinkedList<Company> data = new LinkedList<>();

    @Override
    public Company save(Company company) {
        return ((company != null) ? data.add(company) : false) ? company : null;
    }

    @Override
    public List<Company> findAll() {
        return data.stream().toList();
    }
}
