package org.example.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class Bill extends Exchange{

    private int id;


    @Builder
    public Bill(Date date, int companyId, int customerId, double price, int id) {
        super(date, companyId, customerId, price);
        this.id = id;
    }

}
