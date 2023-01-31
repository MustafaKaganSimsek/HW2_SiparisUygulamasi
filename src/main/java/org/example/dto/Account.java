package org.example.dto;

import lombok.*;

import java.lang.annotation.Inherited;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Account extends Auditing {

    private String name;
    private int bill;

    public Account(String name, int bill, LocalDate localDate) {
        super(localDate);
        this.name = name;
        this.bill = bill;
    }
}
