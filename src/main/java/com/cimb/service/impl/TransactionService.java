package com.cimb.service.impl;

import com.cimb.model.Transaction;
import com.cimb.repository.TransactionRepository;
import com.cimb.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Transaction Service Impl.
 */
@Service
public class TransactionService implements ITransactionService {

    /**
     * Transaction Repository used for database operations.
     */
    @Autowired
    private TransactionRepository repository;

    /**
     * Create's new transaction.
     *
     * @param transaction transaction entity.
     * @return transaction.
     */
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    /**
     * Retrieve's all transactions of a customer.
     *
     * @param cif Customer information file.
     * @return set containing customer transaction details.
     */
    @Override
    public Set<Transaction> findAllCustomerTransByCif(String cif) {
        return repository.findAllCustomerTransByCif(cif);
    }
}
