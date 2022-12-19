package com.bank.ravbanking.domains;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "accountId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String accountType;
    private String accountNumber;
    private String accountBalance;
    private String accountCurrency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

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
