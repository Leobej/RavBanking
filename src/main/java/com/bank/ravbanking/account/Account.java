package com.bank.ravbanking.account;

import com.bank.ravbanking.customer.Customer;
import com.bank.ravbanking.transaction.Transaction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String accountType;
    private String accountNumber;
    private String accountBalance;
    private String accountCurrency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
//    private Transaction transaction;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "transactionId", referencedColumnName = "transactionId")
//    private Transaction transaction;

    public Account() {
    }

    public Account(String accountType, String accountNumber, String accountBalance, String accountCurrency, Customer customer) {

        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountCurrency = accountCurrency;
        this.customer = customer;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
