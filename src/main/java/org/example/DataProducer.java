package org.example;

import org.example.dto.Bill;
import org.example.dto.Company;
import org.example.dto.Customer;
import org.example.dto.Order;
import org.example.repository.Repo;
import org.example.repository.impl.BillRepo;
import org.example.repository.impl.CompanyRepo;
import org.example.repository.impl.CustomerRepo;
import org.example.service.BillService;
import org.example.service.CompanyService;
import org.example.service.CustomerService;
import org.example.service.OrderService;
import org.example.service.impl.BillServiceImpl;
import org.example.service.impl.CompanyServiceImpl;
import org.example.service.impl.CustomerServiceImpl;
import org.example.service.impl.OrderServiceImpl;

import java.time.LocalDate;
import java.util.Random;

public class DataProducer {

    private final BillService billService;

    private final CustomerService customerService;

    private final CompanyService companyService;

    private final OrderService orderService;




    public DataProducer() {
        this.orderService = new OrderServiceImpl();
        this.companyService = new CompanyServiceImpl();
        this.customerService = new CustomerServiceImpl();
        this.billService = new BillServiceImpl();
    }

    public void produce(){
        customerProducer();
        companyProducer();
        orderProducer();
    }

    private void customerProducer(){
        for (int i = 1;i<10;i++){
            Customer customer = Customer.builder()
                    .id(i)
                    .name("customer"+i)
                    .surname("Surname"+i)

                    .build();

            customerService.save(customer);
        }
    }

    private void companyProducer(){
        for (int i = 1;i<10;i++){
            Company company = Company.builder()
                    .id(i)
                    .name("company"+i)
                    .sector("sector"+integerProducer(1,3))
                    .build();
            companyService.save(company);
        }
    }

    private void orderProducer(){
        for (int i = 1;i<50;i++){
            Order order = Order.builder()
                    .id(i)
                    .price(integerProducer(250,1750))
                    .companyId(integerProducer(1,10))
                    .customerId(integerProducer(1,10))
                    .build();

            orderService.createOrder(order);
        }
    }

//    private void billProducer(){
//        for (int i = 1;i<50;i++){
//            Bill bill = Bill.builder()
//                    .id(i)
//                    .price(integerProducer(250,1750))
//                    .companyId(integerProducer(1,10))
//                    .customerId(integerProducer(1,10))
//                    .build();
//            billService.save(bill);
//        }
//    }

    //start and end are inclusive
    private int integerProducer(int start,int end){
        Random random = new Random();
        return random.nextInt(end+1-start)+start;
    }

}
