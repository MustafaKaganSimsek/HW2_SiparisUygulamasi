package org.example;

import lombok.RequiredArgsConstructor;
import org.example.dto.Bill;
import org.example.service.BillService;
import org.example.service.impl.BillServiceImpl;

import javax.inject.Inject;
import java.util.List;


public class MainService {

    BillService billService;


    public MainService() {
        this.billService = new BillServiceImpl();
    }





//    public void saveBill(){
//        Bill bill = Bill.builder().(1500).build();
//        billService.save(bill);
//    }

    public List<Bill> findAllBill(){
        return billService.findAll();
    }

    public List<Bill> filterByUnderBillAmount(int number) {

        return billService.filterByUnderBillAmount(number);
    }

    public List<Bill> filterByUpperBillAmount(int number) {

        return billService.filterByUpperBillAmount(number);
    }
}
