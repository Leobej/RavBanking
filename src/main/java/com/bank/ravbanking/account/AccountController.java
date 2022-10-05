package com.bank.ravbanking.account;

import com.bank.ravbanking.customer.Customer;
import com.bank.ravbanking.customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping
    public void registerNewAccount(@RequestBody Account account) {
        accountService.addNewAccount(account);
    }

    @DeleteMapping(path = "{accountId}")
    public void deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.deleteAccount(accountId);
    }

    @PutMapping(path = "{accountId}")
    public void updateAccount(
            @PathVariable("accountId") Long accountId,
            @RequestParam(required = false) String accountType,
            @RequestParam(required = false) String accountNumber,
            @RequestParam(required = false) String accountBalance,
            @RequestParam(required = false) String accountCurrency,
            @RequestParam(required = false) Customer customer)
            {
        accountService.updateAccount(accountId, accountType, accountNumber, accountBalance, accountCurrency,customer );//
    }



}
