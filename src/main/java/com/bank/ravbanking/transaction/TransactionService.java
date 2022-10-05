package com.bank.ravbanking.transaction;

import com.bank.ravbanking.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public void addNewTransaction(Transaction transaction) {
        Optional<Transaction> transactionOptional = transactionRepository.findTransactionBy(transaction.getTransactionId());
        if (transactionOptional.isPresent()) {
            throw new IllegalStateException("id taken");
        }
        transactionRepository.save(transaction);
        System.out.println(transaction);
    }
}
