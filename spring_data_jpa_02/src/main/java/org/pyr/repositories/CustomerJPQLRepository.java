package org.pyr.repositories;

import org.pyr.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerJPQLRepository extends PagingAndSortingRepository<Customer, Long> {

    @Query("From Customer where custName = :custName")
    Customer findCustomerByCustName(@Param("custName") String custName);

    @Query("From Customer where custName = ?1")
    Customer findCustomerByCustName2(String custName);

    @Transactional // 通常在业务逻辑中service增加，而不是这里
    @Modifying
    @Query("UPDATE Customer set custName = :custName where custId = :custId")
    int updateCutomserNameById(@Param("custName") String custName, @Param("custId") long custId);

    @Transactional // 通常在业务逻辑中service增加，而不是这里
    @Modifying
    @Query("DELETE from Customer where custId = :custId")
    int deleteCutomserById(@Param("custId") long custId);

    @Query(value = "select * from cst_customer where cust_name = :custName", nativeQuery = true)
    Customer findCustomerByCustNameWithNative(@Param("custName") String custName);
}
