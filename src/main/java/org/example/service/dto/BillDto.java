package org.example.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.model.Company;
import org.example.model.Customer;

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
