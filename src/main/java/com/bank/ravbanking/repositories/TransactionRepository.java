package com.bank.ravbanking.repositories;

import com.bank.ravbanking.domains.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT s FROM Transaction s WHERE s.transactionId = ?1")
    Optional<Transaction> findTransactionBy(Long transactionId);
}

