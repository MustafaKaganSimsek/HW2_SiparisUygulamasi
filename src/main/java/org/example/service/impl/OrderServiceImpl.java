package org.example.service.impl;

import org.example.model.Order;
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
