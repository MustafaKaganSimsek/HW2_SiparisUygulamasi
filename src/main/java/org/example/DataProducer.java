package org.example;

import org.example.model.Company;
import org.example.model.Customer;
import org.example.model.Order;
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
import java.util.concurrent.ThreadLocalRandom;

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
        for (int i = 1;i<=10;i++){
            Customer customer = Customer.builder()
                    .name(nameProducer())
                    .surname(nameProducer())
                    .build();

            customerService.save(customer);
        }
    }

    private void companyProducer(){
        for (int i = 1;i<=10;i++){
            Company company = Company.builder()
                    .name(nameProducer())
                    .sector("sector"+integerProducer(1,3))
                    .build();
            companyService.save(company);
        }
    }

    private void orderProducer(){
        for (int i = 1;i<=50;i++){
            Order order = Order.builder()
                    .price(integerProducer(250,1750))
                    .companyId(integerProducer(1,10))
                    .customerId(integerProducer(1,10))
                    .build();

            orderService.createOrder(order);
        }
    }


    //start and end are inclusive
    private int integerProducer(int start,int end){
        Random random = new Random();
        return random.nextInt(end+1-start)+start;
    }

    private String nameProducer(){

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

}
