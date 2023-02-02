package org.HW2.service.impl;

import org.HW2.service.BillService;
import org.HW2.service.OrderService;
import org.HW2.service.dto.OrderRequest;

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
