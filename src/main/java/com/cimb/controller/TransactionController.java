package com.cimb.controller;

import com.cimb.model.Transaction;
import com.cimb.service.ITransactionService;
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
 * Transaction Controller.
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    /**
     * Logger.
     */
    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    /**
     * Transaction Service used for operations.
     */
    @Autowired
    private ITransactionService transactionService;
    
    /**
     * Create's new transaction.
     *
     * @param transaction transaction entity.
     * @return Response entity.
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity createTransaction(@RequestBody Transaction transaction) {
        Transaction tran = transactionService.createTransaction(transaction);
        if (tran == null) {
            String message = String.format("Failed to create transaction.");
            logger.error(message);
            return new ResponseEntity(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(tran, HttpStatus.OK);
    }
    
    /**
     * Retrieve's all transactions of a customer.
     *
     * @param cif Customer information file.
     * @return Response entity based on results.
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity findAllCustomerTransByCif(@RequestParam String cif) {
        Set<Transaction> transactions = transactionService.findAllCustomerTransByCif(cif);
        if (transactions.isEmpty()) {
            logger.warn("No records found");
            return new ResponseEntity("No records found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(transactions, HttpStatus.OK);
    }
}
