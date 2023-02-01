package org.example.service;

import org.example.model.Bill;
import org.example.model.Order;

import java.util.List;

public interface BillService {

 Bill save (Order order);

 List<Bill> findAll();

 List<Bill> filterByUnderBillAmount(int number);

 List<Bill> filterByUpperBillAmount(int number);


}
