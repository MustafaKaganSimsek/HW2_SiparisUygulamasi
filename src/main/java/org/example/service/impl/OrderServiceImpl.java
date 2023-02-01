package org.example.service.impl;

import org.example.model.Order;
import org.example.service.BillService;
import org.example.service.OrderService;
import org.example.service.dto.OrderRequest;

public class OrderServiceImpl implements OrderService {

    private final BillService billService;

    public OrderServiceImpl() {
        this.billService = new BillServiceImpl();
    }


    @Override
    public OrderRequest createOrder(OrderRequest order) {
        billService.save(order);
        return order;

    }
}
