package org.example.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CompanyDto {

    private int id;
    private String name;
    private String sector;
    private Date date;
}
