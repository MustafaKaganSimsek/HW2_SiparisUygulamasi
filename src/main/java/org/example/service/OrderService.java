package org.example.service;

import org.example.service.dto.OrderRequest;

public interface OrderService {

    OrderRequest createOrder(OrderRequest order);
}
