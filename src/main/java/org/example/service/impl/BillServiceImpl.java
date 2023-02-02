package org.example.service.impl;

import org.example.model.Bill;
import org.example.repository.Repo;
import org.example.repository.impl.BillRepo;
import org.example.service.AuditingService;
import org.example.service.BillService;
import org.example.service.dto.BillDto;
import org.example.service.dto.OrderRequest;
import org.example.service.dto.converter.BillDtoConverter;

import java.util.List;

public class BillServiceImpl implements BillService {

    private static int id=1;

    private final Repo<Bill> billRepo;
    private final AuditingService auditingService;
    private final BillDtoConverter billDtoConverter;

    public BillServiceImpl() {
        this.billDtoConverter = new BillDtoConverter();
        this.auditingService = new AuditingService();
        this.billRepo = new BillRepo();
    }

    @Override
    public BillDto save(OrderRequest order) {
        if (order==null){
            return null;
        }else {
            Bill bill = Bill.builder()
                    .id(id)
                    .price(order.getPrice())
                    .customer(order.getCustomer())
                    .company(order.getCompany())
                    .date(auditingService.between())
                    .build();
            id++;
            return billDtoConverter.convert(billRepo.save(bill));
        }
    }

    @Override
    public List<BillDto> findAll() {
        return billDtoConverter.convert(billRepo.findAll());

    }

    @Override
    public List<BillDto> findBillByCreatingMonthOfCustomer(int month) {
        return billDtoConverter.convert(billRepo.findAll().stream().filter(bill -> bill.getCustomer().getDate().getMonth()==month)
                .toList());
    }

    @Override
    public List<BillDto> filterByUnderBillAmount(int number) {

        return billDtoConverter.convert(billRepo.findAll().stream()
                .filter(bill -> bill.getPrice()<number)
                .toList());
    }


    @Override
    public List<BillDto> filterByUpperBillAmount(int number) {

        return billDtoConverter.convert(billRepo.findAll().stream()
                .filter(bill -> bill.getPrice()>number)
                .toList());
    }

    @Override
    public double avaregeOfUnderBillAmount(int number) {
        return filterByUpperBillAmount(number).stream()
                .mapToDouble(BillDto::getPrice).average()
                .getAsDouble();
    }


}
