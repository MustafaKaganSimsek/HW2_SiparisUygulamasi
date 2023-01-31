package org.example.repository.impl;

import org.example.dto.Bill;
import org.example.repository.Repo;

import java.util.LinkedList;
import java.util.List;

public class BillRepo implements Repo<Bill> {

    private static LinkedList<Bill> data = new LinkedList<>();

    @Override
    public Bill save(Bill bill) {

    return ((bill != null) ? data.add(bill) : false) ? bill : null;

    }

    @Override
    public List<Bill> findAll() {
            return data.stream().toList();
    }


}
