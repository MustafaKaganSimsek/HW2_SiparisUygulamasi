package org.HW2.service;

import org.HW2.service.dto.OrderRequest;

public interface OrderService {

    OrderRequest createOrder(OrderRequest order);
}
