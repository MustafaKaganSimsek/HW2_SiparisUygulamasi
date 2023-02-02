package org.HW2.service.impl;

import org.HW2.model.Bill;
import org.HW2.repository.Repo;
import org.HW2.repository.impl.BillRepo;
import org.HW2.service.AuditingService;
import org.HW2.service.BillService;
import org.HW2.service.dto.BillDto;
import org.HW2.service.dto.OrderRequest;
import org.HW2.service.dto.converter.BillDtoConverter;

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
