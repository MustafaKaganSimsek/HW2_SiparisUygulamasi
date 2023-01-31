package org.example.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class Bill extends Exchange{

    @Generated
    private int id;


    @Builder
    public Bill(LocalDate localDate, int companyId, int customerId, double price, int id) {
        super(localDate, companyId, customerId, price);
        this.id = id;
    }

}
