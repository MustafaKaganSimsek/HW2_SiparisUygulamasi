package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.service.BillService;
import org.example.service.CompanyService;
import org.example.service.CustomerService;
import org.example.service.impl.BillServiceImpl;
import org.example.service.impl.CompanyServiceImpl;
import org.example.service.impl.CustomerServiceImpl;

public class Main {

//    Inject
//    private BillService billService;@

//    private static void a( BillService billService){
//        Bill bill = Bill.builder().amount(1500).build();
//        billService.save(bill);
//    }


    public static void main(String[] args) {
        Gson gson =new GsonBuilder().setPrettyPrinting().create();
        DataProducer dataProducer = new DataProducer();
        BillService billService = new BillServiceImpl();
        CompanyService companyService = new CompanyServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        dataProducer.produce();
        MainService mainService = new MainService();
        customerService.findAll().forEach(customer -> System.out.println(gson.toJson(customer)));
        System.out.println("Company names containing \"C\"");
        customerService.findByNameContains("c").forEach(customer -> System.out.println(gson.toJson(customer)));
        System.out.println("company---------------------------------");
        companyService.findAll().forEach(customer -> System.out.println(gson.toJson(customer)));
        billService.findAll().forEach(bill -> System.out.println(gson.toJson(bill)));
        billService.filterByUnderBillAmount(1500).forEach(bill -> System.out.println(gson.toJson(bill)));
        billService.filterByUpperBillAmount(1500).forEach(bill -> System.out.println(gson.toJson(bill)));
        mainService.filterByUpperBillAmount(1500).forEach(bill -> System.out.println(bill));

    }
}