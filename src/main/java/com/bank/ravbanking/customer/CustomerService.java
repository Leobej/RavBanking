package com.bank.ravbanking.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
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
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerById(customer.getCustomerId());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("id taken");
        }
        customerRepository.save(customer);
        System.out.println(customer);
    }

    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if (!exists) {
            throw new IllegalStateException("customer with id " + customerId + " does not exist");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(Long customerId, String firstname, String lastName) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("customer with id " + customerId + " does not exist"));
        if (firstname != null && firstname.length() > 0 && !customer.getFirstName().equals(firstname)) {
            customer.setFirstName(firstname);
        }
        if (lastName != null && lastName.length() > 0 && !customer.getLastName().equals(lastName)) {
            customer.setLastName(lastName);
        }
    }
}
