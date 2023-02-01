package org.example.dto;

import lombok.*;

import java.lang.annotation.Inherited;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Account extends Auditing {

    private String name;
    private List<Bill> bill;

    public Account(String name, List<Bill> bill, Date date) {
        super(date);
        this.name = name;
        this.bill = bill;
    }
}
