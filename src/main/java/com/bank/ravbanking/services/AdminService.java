package com.bank.ravbanking.services;

import com.bank.ravbanking.domains.Admin;
import com.bank.ravbanking.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    //    public void addNewCustomer(Customer customer) {
//        customerRepository.findCustomerById(customer.getCustomerId()).ifPresentOrElse(
//                (id) -> {
//                    throw new IllegalStateException("id taken");
//                },
//                () -> {
//                    customerRepository.save(customer);
//                }
//        );
//    }
    public void addNewCustomer(Admin admin) {
        Optional<Admin> adminOptional = adminRepository.findById(admin.getId());
        if (adminOptional.isPresent()) {
            throw new IllegalStateException("id taken");
        }
        adminRepository.save(admin);
        System.out.println(admin);
    }

    public void deleteCustomer(Long customerId) {
        boolean exists = adminRepository.existsById(customerId);
        if (!exists) {
            throw new IllegalStateException("customer with id " + customerId + " does not exist");
        }
        adminRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(Long customerId, String firstname, String lastName) {

        Admin admin = adminRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("admin with id " + customerId + " does not exist"));
        if (firstname != null && firstname.length() > 0 && !admin.getFirstName().equals(firstname)) {
            admin.setFirstName(firstname);
        }
        if (lastName != null && lastName.length() > 0 && !admin.getLastName().equals(lastName)) {
            admin.setLastName(lastName);
        }
    }
}
