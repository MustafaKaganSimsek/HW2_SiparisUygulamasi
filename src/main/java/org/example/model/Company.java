package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Company extends Account{
    private int id;

    private String sector;

    @Builder
    public Company(String name, List<Bill> bill, String sector, int id, Date date) {
        super(name,bill,date);
        this.sector=sector;
        this.id = id;
    }
}
