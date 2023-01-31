package org.example.service.impl;

import org.example.dto.Bill;
import org.example.dto.Order;
import org.example.service.BillService;
import org.example.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private final BillService billService;

    public OrderServiceImpl() {
        this.billService = new BillServiceImpl();
    }


    @Override
    public Order createOrder(Order order) {
        billService.save(order);
        return order;

    }
}
