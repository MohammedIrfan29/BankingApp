package com.cimb.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cimb.model.Customer;
import com.cimb.repository.CustomerRepository;
import com.cimb.service.ICustomerService;

/**
 * Customer Service Impl.
 */
@Service
public class CustomerService implements ICustomerService {

    /**
     * Customer Repository used for database operations.
     */
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Register new customer.
     *
     * @param customer Customer.
     * @return Customer details.
     */
    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
   
    /**
     * Retrieve's all customer's bank accounts by opening date.
     *
     * @param openingDate Account Opening date.
     * @return set containing customer bank accounts details.
     */
    @Override
    public Set<Customer> findAllCustAccountByOpeningDate(String openingDate) {
        return customerRepository.findAllCustAccountByOpeningDate(openingDate);
    }
}
