package org.HW2.service.dto.converter;


import org.HW2.model.Bill;
import org.HW2.service.dto.BillDto;

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
