package com.danix.code.smell.example001;

/**
 * @author danix
 */
public class CustomerFactory {

    public Customer createCompany(String name, String email, Account account, double companyOverdraftDiscount) {
        return new Customer(name, "", email, CustomerType.COMPANY, account, companyOverdraftDiscount);
    }

    public Customer createPerson(String name, String surname, String email, Account account) {
        return new Customer(name, surname, email, CustomerType.PERSON, account, 1);
    }
}
