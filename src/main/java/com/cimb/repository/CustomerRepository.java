package com.cimb.repository;

import com.cimb.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Customer Repository
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    /**
     * Retrieve's all customer's bank accounts by opening date.
     *
     * @param openingDate Account Opening date.
     * @return set containing customer bank accounts details.
     */
    @Query(value = "SELECT c.cif, c.name, c.date_of_birth, c.on_boarding_date, c.phone_number " +
            "FROM Customer c Join Bank_Account ba on c.cif = ba.customer_cif and " +
            "ba.opening_date = to_date(:openingDate, 'yyyy-MM-dd')", nativeQuery = true)
    Set<Customer> findAllCustAccountByOpeningDate(String openingDate);
}
