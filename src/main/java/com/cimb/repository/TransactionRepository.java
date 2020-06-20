package com.cimb.repository;

import com.cimb.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Transaction Repository.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /**
     * Retrieve's all transactions of a customer.
     *
     * @param cif Customer information file.
     * @return set containing customer transaction details.
     */
    @Query(value = "SELECT c.cif, c.name, t.tran_id, t.amount, t.time, t.currency, t.status, t.account_number " +
            "FROM Customer c Join Bank_Account ba on c.cif = ba.customer_cif " +
            "Join Transaction t on ba.account_number = t.account_number and c.cif = :cif", nativeQuery = true)
    Set<Transaction> findAllCustomerTransByCif(String cif);
}
