package org.HW2;

import org.HW2.model.Company;
import org.HW2.model.Customer;
import org.HW2.service.BillService;
import org.HW2.service.CompanyService;
import org.HW2.service.CustomerService;
import org.HW2.service.OrderService;
import org.HW2.service.dto.OrderRequest;
import org.HW2.service.impl.BillServiceImpl;
import org.HW2.service.impl.CompanyServiceImpl;
import org.HW2.service.impl.CustomerServiceImpl;
import org.HW2.service.impl.OrderServiceImpl;

import java.util.List;
import java.util.Random;

public class DataProducer {


    private final CustomerService customerService;

    private final CompanyService companyService;

    private final OrderService orderService;




    public DataProducer() {
        this.orderService = new OrderServiceImpl();
        this.companyService = new CompanyServiceImpl();
        this.customerService = new CustomerServiceImpl();
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
        List<Company> companies = List.copyOf(companyService.findAll());
        List<Customer> customer = List.copyOf(customerService.findAll());

        for (int i = 1;i<=50;i++){
            OrderRequest order = OrderRequest.builder()
                    .price(integerProducer(250,1750))
                    .company(companies.get(integerProducer(0,companies.size()-1)))
                    .customer(customer.get(integerProducer(0,customer.size()-1)))
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
