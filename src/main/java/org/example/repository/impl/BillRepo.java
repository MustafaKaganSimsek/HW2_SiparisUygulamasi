package org.example.repository.impl;

import org.example.dto.Bill;
import org.example.repository.Repo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BillRepo implements Repo<Bill> {

    private static HashMap<Number,Bill> data = new HashMap<>();

    @Override
    public Bill save(Bill bill) {

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
