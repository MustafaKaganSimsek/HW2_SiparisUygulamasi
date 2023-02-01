package org.example.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class Bill extends Auditing {

    private int id;
    private int companyId;
    private int customerId;
    private double price;

    @Builder
    public Bill(int id, int companyId, int customerId, double price,Date date) {
        super(date);
        this.id = id;
        this.companyId = companyId;
        this.customerId = customerId;
        this.price = price;
    }
}
