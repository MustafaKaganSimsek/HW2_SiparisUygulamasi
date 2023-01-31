package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.dto.Auditing;

import java.time.LocalDate;

@Setter
@Getter
public class Exchange extends Auditing {
    private int companyId;
    private int customerId;
    private double price;

    public Exchange(LocalDate localDate, int companyId, int customerId, double price) {
        super(localDate);
        this.companyId = companyId;
        this.customerId = customerId;
        this.price = price;
    }
}
