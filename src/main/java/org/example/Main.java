package org.example;

import com.google.gson.Gson;
import org.example.dto.Bill;
import org.example.dto.Customer;
import org.example.service.BillService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import java.beans.JavaBean;

public class Main {

//    Inject
//    private BillService billService;@

//    private static void a( BillService billService){
//        Bill bill = Bill.builder().amount(1500).build();
//        billService.save(bill);
//    }


    public static void main(String[] args) {
        Gson gson =new Gson();
        DataProducer dataProducer = new DataProducer();
        dataProducer.produce();
        MainService mainService = new MainService();
//        mainService.saveBill();
        mainService.findAllBill().forEach(bill -> System.out.println(bill.getPrice()));
        mainService.filterByUnderBillAmount(1500).forEach(bill -> System.out.println(bill));
        mainService.filterByUpperBillAmount(1500).forEach(bill -> System.out.println(bill));

    }
}