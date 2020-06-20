package com.cimb.service.impl;

import com.cimb.model.BankAccount;
import com.cimb.repository.BankAccountRepository;
import com.cimb.service.IBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Bank Account Service Impl.
 */
@Service
public class BankAccountService implements IBankAccountService {

    /**
     * Bank Account Repository used for database operations.
     */
    @Autowired
    private BankAccountRepository bankAccountRepository;

    /**
     * Retrieve's all bank accounts of a customer by opening date.
     *
     * @param cif         Customer information file.
     * @param openingDate Account Opening date.
     * @return Set containing customer bankAccounts.
     */
    @Override
    public Set<BankAccount> findByCifAndOpeningDate(String cif, String openingDate) {
        return bankAccountRepository.findByCifAndOpeningDate(cif, openingDate);
    }
}
