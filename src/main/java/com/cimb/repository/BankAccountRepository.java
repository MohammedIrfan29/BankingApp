package com.cimb.repository;

import com.cimb.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Bank Account Repository.
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

    /**
     * Retrieve's all bank accounts of a customer by opening date.
     *
     * @param cif         Customer information file.
     * @param openingDate Account Opening date.
     * @return Set containing customer bankAccounts.
     */
    @Query(value = "SELECT ba.account_number, ba.opening_date, ba.balance, ba.status, ba.customer_cif " +
            "FROM Bank_Account ba WHERE ba.customer_cif = :cif AND" +
            " ba.opening_date = to_date(:openingDate, 'yyyy-MM-dd')", nativeQuery = true)
    Set<BankAccount> findByCifAndOpeningDate(String cif, String openingDate);
}
