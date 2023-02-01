package org.example.repository.impl;

import org.example.model.Bill;
import org.example.repository.Repo;

import java.util.HashMap;
import java.util.List;

public class BillRepo implements Repo<Bill> {

    private static HashMap<Number,Bill> data = new HashMap<>();

    @Override
    public Bill save(Bill bill) {
//        CompanyRepo.data.put(bill.getCompanyId(), );

        return data.put(bill.getId(), bill);

    }

    @Override
    public Bill findById(Number id) {
        return data.get(id);
    }

    @Override
    public List<Bill> findAll() {
            return data.values().stream().toList();
    }


}
