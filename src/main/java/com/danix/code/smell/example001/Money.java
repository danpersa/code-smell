package com.danix.code.smell.example001;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author danix
 */
public class Money {

    public static final String EUR_CURRENCY = "EUR";
    private final double amount;
    private final String currency;

    private Money(double amount, @Nonnull String currency) {
        this.amount = amount;
        this.currency = checkNotNull(currency);
    }

    public static Money newInstance(double amount, @Nonnull String currency) {
        return new Money(amount, currency);
    }

    public static Money newEuro(double amount) {
        return new Money(amount, EUR_CURRENCY);
    }

    public double getAmount() {
        return amount;
    }

    @Nonnull
    public String getCurrency() {
        return currency;
    }

    @Nonnull
    public Money substract(@Nonnull Money money) {
        checkNotNull(money);
        if (!money.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't substract different currencies!");
        }
        return new Money(this.amount - money.amount, currency);
    }
}
