package org.HW2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.HW2.model.Customer;
import org.HW2.service.BillService;
import org.HW2.service.CompanyService;
import org.HW2.service.CustomerService;
import org.HW2.service.impl.BillServiceImpl;
import org.HW2.service.impl.CompanyServiceImpl;
import org.HW2.service.impl.CustomerServiceImpl;

public class Main {


    public static void main(String[] args) {
        Gson gson =new GsonBuilder().setPrettyPrinting().create();
        DataProducer dataProducer = new DataProducer();
        BillService billService = new BillServiceImpl();
        CompanyService companyService = new CompanyServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        dataProducer.produce();
        //Creating customer
        customerService.save(Customer.builder().name("ali").surname("yılmaz").build());
        System.out.println("----------------------------------------------\nAll customers\n----------------------------------------------");
        customerService.findAllAsDto().forEach(customer -> System.out.println(gson.toJson(customer)));
        System.out.println("----------------------------------------------\nCompany names containing \"C\"\n----------------------------------------------");
        customerService.findByNameContains("c").forEach(customer -> System.out.println(gson.toJson(customer)));
        System.out.println("----------------------------------------------\nInvoices of customers registered in June\n----------------------------------------------");
        billService.findBillByCreatingMonthOfCustomer(6).forEach(bill -> System.out.println(gson.toJson(bill)));
        System.out.println("----------------------------------------------\nAll bills\n----------------------------------------------");
        billService.findAll().forEach(bill -> System.out.println(gson.toJson(bill)));
        System.out.println("----------------------------------------------\nBills Upper 1500 TL\n----------------------------------------------");
        billService.filterByUpperBillAmount(1500).forEach(bill -> System.out.println(gson.toJson(bill)));
        System.out.println("----------------------------------------------\nAverage of bills over 1500 TL\n----------------------------------------------");
        System.out.println(billService.avaregeOfUnderBillAmount(1500));
        System.out.println("----------------------------------------------\nCustomers with bills under 500 TL in the system\n----------------------------------------------");
        customerService.findNamesOfUnderBillAmount(500).forEach(bill -> System.out.println(gson.toJson(bill)));
        System.out.println("----------------------------------------------\nSectors of companies with an average monthly invoice of less than 750 TL\n----------------------------------------------");
        companyService.findSectorsOfUnderBillAmount(750).forEach(bill -> System.out.println(gson.toJson(bill)));
    }
}