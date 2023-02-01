package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Exchange extends Auditing {
    private int companyId;
    private int customerId;
    private double price;

    public Exchange(Date date, int companyId, int customerId, double price) {
        super(date);
        this.companyId = companyId;
        this.customerId = customerId;
        this.price = price;
    }
}
