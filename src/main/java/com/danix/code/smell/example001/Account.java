package com.danix.code.smell.example001;

/**
 * @author  danix
 */
public class Account {

    private String iban;

    private AccountType type;

    private int daysOverdrawn;

    private Money money;

    private Customer customer;

    public Account(final AccountType type, final int daysOverdrawn) {
        super();
        this.type = type;
        this.daysOverdrawn = daysOverdrawn;
    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (getDaysOverdrawn() > 7) {
                result += (getDaysOverdrawn() - 7) * 1.0;
            }

            return result;
        } else {
            return getDaysOverdrawn() * 1.75;
        }
    }

    public double overdraftFee() {
        if (type.isPremium()) {
            return 0.10;
        } else {
            return 0.20;
        }
    }

    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(final String iban) {
        this.iban = iban;
    }

    public void setMoney(final Money money) {
        this.money = money;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public AccountType getType() {
        return type;
    }

    public boolean isOverdraft() {
        return money.getAmount() < 0;
    }

    public void substract(final Money money) {
        this.money = this.money.substract(money);
    }

    public double getMoneyAmount() {
        return money.getAmount();
    }
}
