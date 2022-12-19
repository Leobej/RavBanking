package com.bank.ravbanking.services;

import com.bank.ravbanking.domains.Transaction;
import com.bank.ravbanking.repositories.TransactionRepository;
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
        transaction.getFromAccount().setAccountId(transaction.getFromAccount().getAccountId());
        transaction.getToAccount().setAccountId(transaction.getToAccount().getAccountId());
        transactionRepository.save(transaction);
        System.out.println(transaction);
    }
}
