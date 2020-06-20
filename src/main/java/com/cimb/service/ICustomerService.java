package com.cimb.service;

import com.cimb.model.Customer;

import java.util.Set;

/**
 * Customer Service.
 */
public interface ICustomerService {

    /**
     * Register new customer.
     *
     * @param customer Customer.
     * @return Customer details.
     */
    Customer registerCustomer(Customer customer);

    /**
     * Retrieve's all customer's bank accounts by opening date.
     *
     * @param openingDate Account Opening date.
     * @return set containing customer bank accounts details.
     */
    Set<Customer> findAllCustAccountByOpeningDate(String openingDate);
}
