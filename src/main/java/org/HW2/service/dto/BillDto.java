package org.HW2.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class BillDto {
    private int id;
    private CompanyDto company;
    private CustomerDto customer;
    private double price;
    private Date date;
}
