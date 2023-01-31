package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

public class Customer extends Account{
    private int id;

    private String surname;



    @Builder
    public Customer(String name, int bill, String surname, int id, LocalDate localDate) {
        super(name,bill,localDate);
        this.surname=surname;
        this.id = id;
    }
}
