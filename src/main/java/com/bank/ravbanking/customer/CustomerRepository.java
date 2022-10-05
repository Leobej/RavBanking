package com.bank.ravbanking.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT s FROM Customer s WHERE s.customerId = ?1")
    Optional<Customer> findCustomerById(Long customerId);


}
