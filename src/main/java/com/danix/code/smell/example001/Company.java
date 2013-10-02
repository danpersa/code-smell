package com.danix.code.smell.example001;

/**
 * @author  danix
 */
public class Company extends Customer {

    protected double companyOverdraftDiscount = 1;

    Company(final String name, final String email, final Account account, final double companyOverdraftDiscount) {
        super(name, email, account);
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    @Override
    public void withdraw(final Money money) {
        if (account.getType().isPremium()) {
            if (account.isOverdraft()) {

                // 50 percent discount for overdraft for premium account
                account.substract(Money.newInstance(
                        money.getAmount() + money.getAmount() * account.overdraftFee() * companyOverdraftDiscount / 2,
                        money.getCurrency()));
            } else {
                account.substract(Money.newInstance(money.getAmount(), money.getCurrency()));
            }
        } else {
            if (account.isOverdraft()) {

                // no discount for overdraft for not premium account
                account.substract(Money.newInstance(
                        money.getAmount() + money.getAmount() * account.overdraftFee() * companyOverdraftDiscount,
                        money.getCurrency()));
            } else {
                account.substract(Money.newInstance(money.getAmount(), money.getCurrency()));
            }
        }
    }

    @Override
    protected String getFullName() {
        return name;
    }
}
