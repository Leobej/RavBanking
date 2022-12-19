package com.bank.ravbanking.controllers;

import com.bank.ravbanking.domains.Admin;
import com.bank.ravbanking.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getCustomers() {
        return adminService.getAdmins();
    }

    @PostMapping
    public void registerNewCustomer(@RequestBody Admin admin) {
        adminService.addNewCustomer(admin);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        adminService.deleteCustomer(customerId);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        adminService.updateCustomer(id, firstName, lastName);
    }
}
