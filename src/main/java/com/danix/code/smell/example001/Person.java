package com.danix.code.smell.example001;

/**
 * @author  danix
 */
public class Person extends Customer {
    protected String surname;

    Person(final String name, final String surname, final String email, final Account account) {
        super(name, email, account);
        this.surname = surname;
    }

    @Override
    public void withdraw(final Money money) {
        if (account.getType().isPremium()) {
            if (account.isOverdraft()) {
                account.substract(Money.newInstance(money.getAmount() + money.getAmount() * account.overdraftFee(),
                        money.getCurrency()));
            } else {
                account.substract(Money.newInstance(money.getAmount(), money.getCurrency()));
            }
        } else {
            if (account.isOverdraft()) {
                account.substract(Money.newInstance(money.getAmount() + money.getAmount() * account.overdraftFee(),
                        money.getCurrency()));
            } else {
                account.substract(Money.newInstance(money.getAmount(), money.getCurrency()));
            }
        }
    }

    @Override
    protected String getFullName() {
        return name + " " + surname + " ";
    }
}
