package com.cimb.service;

import com.cimb.model.Transaction;

import java.util.Set;

/**
 * Transaction Service.
 */
public interface ITransactionService {

    /**
     * Create's new transaction.
     *
     * @param transaction transaction entity.
     * @return transaction.
     */
    Transaction createTransaction(Transaction transaction);

    /**
     * Retrieve's all transactions of a customer.
     *
     * @param cif Customer information file.
     * @return set containing customer transaction details.
     */
    Set<Transaction> findAllCustomerTransByCif(String cif);
}
