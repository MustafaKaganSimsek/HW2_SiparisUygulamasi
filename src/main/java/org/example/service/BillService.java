package org.example.service;

import org.example.dto.Bill;
import org.example.dto.Customer;
import org.example.dto.Order;

import java.util.List;

public interface BillService {

 Bill save (Order order);

 List<Bill> findAll();

 List<Bill> filterByUnderBillAmount(int number);

 List<Bill> filterByUpperBillAmount(int number);


}
