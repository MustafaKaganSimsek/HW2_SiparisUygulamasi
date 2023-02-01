package org.example.service.dto.converter;

import org.example.model.Company;
import org.example.service.dto.CompanyDto;

import java.util.List;

public class CompanyDtoConverter {

    public CompanyDto convert(Company from){
        return new CompanyDto(from.getId(), from.getName(), from.getSector(), from.getDate());
    }
    public List<CompanyDto> convert(List<Company> fromList){
        return fromList.stream()
                .map(from -> convert(from))
                .toList();
    }
}
