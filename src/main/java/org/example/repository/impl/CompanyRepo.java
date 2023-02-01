package org.example.repository.impl;

import org.example.dto.Bill;
import org.example.dto.Company;
import org.example.repository.Repo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CompanyRepo implements Repo<Company> {

    private static HashMap<Number,Company> data = new HashMap<>();

    @Override
    public Company save(Company company) {
        return data.put(company.getId(),company);
    }

    @Override
    public Company findById(Number id) {
        return data.get(id);
    }

    @Override
    public List<Company> findAll() {
        return data.values().stream().toList();
    }
}
