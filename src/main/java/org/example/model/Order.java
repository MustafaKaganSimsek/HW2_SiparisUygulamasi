package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order extends Exchange{
    private int id;

    @Builder
    public Order(Date date, int companyId, int customerId, double price, int id) {
        super(date, companyId, customerId, price);
        this.id = id;
    }
}
