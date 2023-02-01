package org.example.repository.impl;

import org.example.model.Company;
import org.example.repository.Repo;

import java.util.HashMap;
import java.util.List;

public class CompanyRepo implements Repo<Company> {

    protected static HashMap<Number,Company> data = new HashMap<>();

    @Override
    public Company save(Company company) {
        data.put(company.getId(),company);
        return data.get(company.getId());
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
