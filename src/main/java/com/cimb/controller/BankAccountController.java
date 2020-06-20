package com.cimb.controller;

import com.cimb.model.BankAccount;
import com.cimb.service.IBankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Bank Account Controller.
 */
@RestController
@RequestMapping("/account")
public class BankAccountController {

    /**
     * Logger.
     */
    Logger logger = LoggerFactory.getLogger(BankAccountController.class);

    /**
     * Bank Account Service used for operations.
     */
    @Autowired
    private IBankAccountService bankAccountService;
    
    /**
     * Retrieve's all bank accounts of a customer by opening date.
     *
     * @param cif         Customer information file.
     * @param openingDate Account Opening date.
     * @return Response entity based on results.
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<Object> findByCifAndOpeningDate(@RequestParam String cif, @RequestParam String openingDate) {
        Set<BankAccount> bankAccounts = bankAccountService.findByCifAndOpeningDate(cif, openingDate);
        if (bankAccounts.isEmpty()) {
            logger.warn("No records found");
            return new ResponseEntity("No records found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(bankAccounts, HttpStatus.OK);
    }
}
