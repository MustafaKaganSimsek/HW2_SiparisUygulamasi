package org.example.service;

import org.example.service.dto.BillDto;
import org.example.service.dto.OrderRequest;

import java.util.List;

public interface BillService {

 BillDto save (OrderRequest order);

 List<BillDto> findAll();

 List<BillDto> filterByUnderBillAmount(int number);

 List<BillDto> filterByUpperBillAmount(int number);


}
