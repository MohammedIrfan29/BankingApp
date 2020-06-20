package com.cimb.service;

import com.cimb.model.BankAccount;

import java.util.Set;

/**
 * Bank Account Service
 */
public interface IBankAccountService {

    /**
     * Retrieve's all bank accounts of a customer by opening date.
     *
     * @param cif         customer information file.
     * @param openingDate opening date
     * @return Customer BankAccounts
     */
    Set<BankAccount> findByCifAndOpeningDate(String cif, String openingDate);
}
