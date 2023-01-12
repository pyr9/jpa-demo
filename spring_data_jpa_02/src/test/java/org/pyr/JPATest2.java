package org.pyr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pyr.entity.Customer;
import org.pyr.repositories.CustomerJPQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

//@ContextConfiguration(classes = JPAConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JPATest2 {
    @Autowired
    CustomerJPQLRepository customerJPQLRepository;

    @Test
    public void testFindByName(){
        Customer customer = customerJPQLRepository.findCustomerByCustName("徐庶143");
        System.out.println(customer);
    }

    @Test
    public void testFindById(){
        Customer customer = customerJPQLRepository.findCustomerByCustName2("徐庶143");
        System.out.println(customer);
    }

    @Test
    public void testUpdate(){
        customerJPQLRepository.updateCutomserNameById("lisa", 2L);
    }

    @Test
    public void testDelete(){
        customerJPQLRepository.deleteCutomserById(2L);
    }


    @Test
    public void testFindCustomerByCustNameWithNative(){
        Customer customer = customerJPQLRepository.findCustomerByCustNameWithNative("aa");
        System.out.println(customer);
    }


    @Test
    public void testList(){
        Customer customer = new Customer();
        customer.setCustName("111");
//        customer.setCustId(1L);
        Optional.ofNullable(customer.getCustId()).ifPresent(id -> System.out.println("--------------------"+id));

    }
}
