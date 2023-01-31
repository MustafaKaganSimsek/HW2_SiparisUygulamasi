package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Order extends Exchange{
    private int id;

    @Builder
    public Order(LocalDate localDate, int companyId, int customerId, double price, int id) {
        super(localDate, companyId, customerId, price);
        this.id = id;
    }
}
