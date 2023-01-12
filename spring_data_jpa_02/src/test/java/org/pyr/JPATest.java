package org.pyr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pyr.config.JPAConfig;
import org.pyr.entity.Customer;
import org.pyr.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ContextConfiguration(classes = JPAConfig.class)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class JPATest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testFind(){
        Optional<Customer> customer = customerRepository.findById(2L);
        System.out.println(customer.get());
    }

    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setCustId(2L);
        customer.setCreatedAt(new Date());
        customer.setCustName("lisi333,111");
        customer.setAddress("中国12443");
        customerRepository.save(customer);
        System.out.println("DONE!-----------------");
    }


    @Test
    public void testSaveAll() {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            customer.setCustId((long) i);
            customer.setCreatedAt(new Date());
            customer.setCustName("lidd4d111" + i);
            customer.setAddress("中国调查ed04" + i);
            customers.add(customer);
        }
        List<Customer> rs = customerRepository.saveAll(customers);

        String str = rs.stream().map(e -> e.getCustId().toString()).collect(Collectors.joining(","));
        System.out.println("DONE!-----------------" + str);
    }


    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setCustId(13L);
        customer.setCustName("aa123");
        customer.setCreatedAt(new Date());
        customerRepository.save(customer);
        System.out.println((Customer) null);

    }

    @Test
    public void testDelete(){
        Customer customer = new Customer();
        customer.setCustId(3L);
        customer.setCustName("aa123");
        customerRepository.delete(customer);
    }

    @Test
    public void test(){
        List<Long> originAttachmentIds = new ArrayList<>();
//        originAttachmentIds.add(1L);
//        originAttachmentIds.add(2L);
        List<Long> attachmentFileIds = new ArrayList<>();
        attachmentFileIds.add(3L);
        attachmentFileIds.add(2L);
        List<Long> deletedAttachmentIds = originAttachmentIds.stream().filter(id -> !attachmentFileIds.contains(id)).collect(Collectors.toList());
        List<Long> addedAttachmentIds = attachmentFileIds.stream().filter(id -> !originAttachmentIds.contains(id)).collect(Collectors.toList());
        System.out.println(deletedAttachmentIds);
        System.out.println(addedAttachmentIds);
    }
}
