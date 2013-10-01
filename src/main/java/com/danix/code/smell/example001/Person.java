package com.danix.code.smell.example001;

/**
 * @author danix
 */
public class Person extends Customer {
    protected String surname;

    Person(String name, String surname, String email, Account account) {
        super(name, email, account);
        this.surname = surname;
    }

    @Override
    public void withdraw(double sum, String currency) {
        if (account.getType().isPremium()) {
            if (account.isOverdraft()) {
                account.substract(Money.newInstance(sum + sum * account.overdraftFee(), currency));
            } else {
                account.substract(Money.newInstance(sum, currency));
            }
        } else {
            if (account.isOverdraft()) {
                account.substract(Money.newInstance(sum + sum * account.overdraftFee(), currency));
            } else {
                account.substract(Money.newInstance(sum, currency));
            }
        }
    }

    @Override
    protected String getFullName() {
        return name + " " + surname + " ";
    }
}
