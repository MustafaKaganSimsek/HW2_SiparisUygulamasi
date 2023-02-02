package org.HW2.repository.impl;

import org.HW2.model.Company;
import org.HW2.repository.Repo;

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
    public List<Company> findAll() {
        return data.values().stream().toList();
    }
}
