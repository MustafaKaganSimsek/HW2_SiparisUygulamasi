package org.HW2.service;

import org.HW2.service.dto.BillDto;
import org.HW2.service.dto.OrderRequest;

import java.util.List;

public interface BillService {

 BillDto save (OrderRequest order);

 List<BillDto> findAll();

 List<BillDto> findBillByCreatingMonthOfCustomer(int month);

 List<BillDto> filterByUnderBillAmount(int number);


 List<BillDto> filterByUpperBillAmount(int number);

 double avaregeOfUnderBillAmount(int number);




}
