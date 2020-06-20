package com.cimb.controller;

import com.cimb.model.Customer;
import com.cimb.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Customer Controller.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    /**
     * Logger.
     */
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    /**
     * Customer Service used for operations.
     */
    @Autowired
    private ICustomerService customerService;
    
   /**
    * Register new customer.
    *
    * @param customer Customer.
    * @return Response entity.
    */
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity registerCustomer(@RequestBody Customer customer) {
        Customer cust = customerService.registerCustomer(customer);
        if (cust == null) {
            String message = String.format("Failed to register customer.");
            logger.error(message);
            return new ResponseEntity(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(cust, HttpStatus.OK);
    }
    
    /**
     * Retrieve's all customer's bank accounts by opening date.
     *
     * @param openingDate Account Opening date.
     * @return Response entity based on results.
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity findAllCustAccountByOpeningDate(@RequestParam String openingDate) {
        Set<Customer> customers = customerService.findAllCustAccountByOpeningDate(openingDate);
        if (customers.isEmpty()) {
            logger.warn("No records found");
            return new ResponseEntity("No records found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customers, HttpStatus.OK);
    }
}
