package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


public class Company extends Account{
    private int id;

    private String sector;



    @Builder
    public Company(String name, int bill, String sector, int id, LocalDate localDate) {
        super(name,bill,localDate);
        this.sector=sector;
        this.id = id;
    }
}
