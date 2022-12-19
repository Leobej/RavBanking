package com.bank.ravbanking.services;

import com.bank.ravbanking.domains.Account;
import com.bank.ravbanking.domains.Customer;
import com.bank.ravbanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }


    public void addNewAccount(Account account) {
        Optional<Account> customerOptional = accountRepository.selectAccountsWithId(account.getAccountId());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("id taken");
        }
        accountRepository.save(account);
        System.out.println(account);
    }

    public void deleteAccount(Long accountId) {
        boolean exists = accountRepository.existsById(accountId);
        if (!exists) {
            throw new IllegalStateException("customer with id " + accountId + " does not exist");
        }
        accountRepository.deleteById(accountId);
    }

    @Transactional
    public void updateAccount(Long accountId, String accountType, String accountNumber, String accountBalance, String accountCurrency, Customer customer) {//

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalStateException("customer with id " + accountId + " does not exist"));
        if (accountType != null && accountType.length() > 0 && !account.getAccountType().equals(accountType)) {
            account.setAccountType(accountType);
        }

        if (accountNumber != null && accountNumber.length() > 0 && !account.getAccountNumber().equals(accountNumber)) {
            account.setAccountNumber(accountNumber);
        }

        if (accountBalance != null && accountBalance.length() > 0 && !account.getAccountBalance().equals(accountBalance)) {
            account.setAccountNumber(accountBalance);
        }

        if (accountCurrency != null && accountCurrency.length() > 0 && !account.getAccountCurrency().equals(accountCurrency)) {
            account.setAccountCurrency(accountCurrency);
        }

        if (customer != null   && !account.getCustomer().equals(customer)) {
            account.setCustomer(customer);
        }
    }

}
