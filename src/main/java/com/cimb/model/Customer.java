package com.cimb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

/**
 * Customer.
 */
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "cif", nullable = false)
    private String cif;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "on_boarding_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date onboardingDate;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_cif")
    private Set<BankAccount> bankAccounts;

    public Customer() {
    }

    public Customer(String cif, String name, Date dateOfBirth, Date onboardingDate, String phoneNumber,
                    Set<BankAccount> bankAccounts) {
        this.cif = cif;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.onboardingDate = onboardingDate;
        this.phoneNumber = phoneNumber;
        this.bankAccounts = bankAccounts;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getOnboardingDate() {
        return onboardingDate;
    }

    public void setOnboardingDate(Date onboardingDate) {
        this.onboardingDate = onboardingDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
