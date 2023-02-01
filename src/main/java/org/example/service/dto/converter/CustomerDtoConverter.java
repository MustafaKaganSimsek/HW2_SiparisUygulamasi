package org.example.service.dto.converter;


import org.example.model.Customer;
import org.example.service.dto.CustomerDto;

import java.util.List;

public class CustomerDtoConverter {

    public CustomerDto convert(Customer from){
        return new CustomerDto(from.getId(), from.getName(),from.getSurname(), from.getDate());
    }
    public List<CustomerDto> convert(List<Customer> fromList){
        return fromList.stream()
                .map(from -> convert(from))
                .toList();
    }
}
