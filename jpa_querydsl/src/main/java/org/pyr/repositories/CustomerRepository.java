package org.pyr.repositories;

import org.pyr.entity.Customer;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> , QuerydslPredicateExecutor<Customer> {
}
