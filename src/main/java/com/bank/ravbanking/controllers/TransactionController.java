package com.bank.ravbanking.controllers;

import com.bank.ravbanking.domains.Transaction;
import com.bank.ravbanking.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping
    public void addNewTransaction(@RequestBody Transaction transaction) {
        transactionService.addNewTransaction(transaction);
    }
}
