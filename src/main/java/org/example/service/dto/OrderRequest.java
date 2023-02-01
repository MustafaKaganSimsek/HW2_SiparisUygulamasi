package org.example.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Company;
import org.example.model.Customer;

@Getter
@Setter
public class OrderRequest {
    private Company company;
    private Customer customer;
    private double price;

    @Builder
    public OrderRequest(Company company, Customer customer, double price) {
        this.company = company;
        this.customer = customer;
        this.price = price;
    }
}
