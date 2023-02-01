package org.example.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private int companyId;
    private int customerId;
    private double price;

    @Builder
    public OrderRequest(int companyId, int customerId, double price) {
        this.companyId = companyId;
        this.customerId = customerId;
        this.price = price;
    }
}
