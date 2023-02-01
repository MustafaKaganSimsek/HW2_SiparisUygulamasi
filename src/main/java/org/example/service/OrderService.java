package org.example.service;

import org.example.model.Order;
import org.example.service.dto.OrderRequest;

public interface OrderService {

    OrderRequest createOrder(OrderRequest order);
}
