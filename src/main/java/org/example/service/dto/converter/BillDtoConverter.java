package org.example.service.dto.converter;


import lombok.AllArgsConstructor;
import org.example.model.Bill;
import org.example.service.dto.BillDto;
import org.example.service.dto.CompanyDto;

import java.util.List;

public class BillDtoConverter {

    private final CompanyDtoConverter companyDtoConverter;
    private final CustomerDtoConverter customerDtoConverter;

    public BillDtoConverter() {
        this.companyDtoConverter = new CompanyDtoConverter();
        this.customerDtoConverter = new CustomerDtoConverter();
    }

    public BillDto convert(Bill from){
        return new BillDto(from.getId(),companyDtoConverter.convert(from.getCompany()),customerDtoConverter.convert(from.getCustomer()),from.getPrice(), from.getDate());
    }

    public List<BillDto> convert(List<Bill> fromList){
        return fromList.stream()
                .map(from -> convert(from))
                .toList();
    }
}
