package org.pry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pyr.config.JPAConfig;
import org.pyr.entity.Customer;
import org.pyr.entity.QCustomer;
import org.pyr.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = JPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryDslTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testFindOne() {
        QCustomer qCustomer = QCustomer.customer;
        Customer customer = customerRepository.findOne(
                qCustomer.custId.eq(4L)
                        .and(qCustomer.custName.eq("aa"))
        ).orElse(null);
        System.out.println(customer);
    }
    @Test
    public void testFindAll() {
        QCustomer qCustomer = QCustomer.customer;
        Iterable<Customer> customers = customerRepository.findAll(
                qCustomer.custId.in(4L, 5L, 6L, 7L)
                        .and(qCustomer.custName.eq("aa"))
        );
        System.out.println(customers);
    }

}
