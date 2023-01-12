package org.pyr.controller;

import org.pyr.entity.Customer;
import org.pyr.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/cus/hello")
    String hello() {
        List<Customer> customers = new ArrayList<>();
        for (int i = 171; i < 180; i++) {
            Customer customer = new Customer();
            customer.setCustId((long) i);
            customer.setCreatedAt(new Date());
            customer.setCustName("lisi" + i);
            customer.setAddress("中国" + i);
            customers.add(customer);
        }
        customerRepository.saveAll(customers);
        return "Hello World";
    }
}
