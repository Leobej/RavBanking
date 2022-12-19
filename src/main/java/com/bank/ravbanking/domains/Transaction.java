package com.bank.ravbanking.domains;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_method")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private String transactionType;
    private String amount;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fromAccount",referencedColumnName = "accountId")//, insertable=false, updatable=false
    private Account fromAccount;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "toAccount", referencedColumnName = "accountId")//
    private Account toAccount;
    private LocalDateTime issuedDate;

    public Transaction(String transactionType, String amount, Account fromAccount, Account toAccount, LocalDateTime issuedDate) {

        this.transactionType = transactionType;
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.issuedDate = issuedDate;
    }
    public Transaction() {

    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public LocalDateTime getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDateTime issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }
}
