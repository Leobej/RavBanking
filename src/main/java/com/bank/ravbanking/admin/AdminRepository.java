package com.bank.ravbanking.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long > {

    @Query("SELECT s FROM Admin s WHERE s.id = ?1")
    Optional<Admin> findById(Long customerId);
}
