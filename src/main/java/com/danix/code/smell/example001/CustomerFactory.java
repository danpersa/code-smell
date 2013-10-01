package com.danix.code.smell.example001;

/**
 * @author danix
 */
public class CustomerFactory {

    public Customer createCompany(String name, String email, Account account, double companyOverdraftDiscount) {
        return new Company(name, email, account, companyOverdraftDiscount);
    }

    public Customer createPerson(String name, String surname, String email, Account account) {
        return new Person(name, surname, email, account);
    }
}
