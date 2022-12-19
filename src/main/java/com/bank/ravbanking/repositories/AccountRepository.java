package com.bank.ravbanking.repositories;


import com.bank.ravbanking.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query("SELECT s FROM Account s WHERE s.accountId = ?1")
    Optional<Account> selectAccountsWithId(Long accountId);
}
