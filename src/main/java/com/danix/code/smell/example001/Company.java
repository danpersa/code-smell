package com.danix.code.smell.example001;

/**
 * @author danix
 */
public class Company extends Customer {

    protected double companyOverdraftDiscount = 1;

    Company(String name, String email, Account account, double companyOverdraftDiscount) {
        super(name, email, account);
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    @Override
    public void withdraw(double sum, String currency) {
        if (account.getType().isPremium()) {
            if (account.isOverdraft()) {
                // 50 percent discount for overdraft for premium account
                account.substract(Money.newInstance(sum + sum * account.overdraftFee() * companyOverdraftDiscount / 2, currency));
            } else {
                account.substract(Money.newInstance(sum, currency));
            }
        } else {
            if (account.isOverdraft()) {
                // no discount for overdraft for not premium account
                account.substract(Money.newInstance(sum + sum * account.overdraftFee() * companyOverdraftDiscount, currency));
            } else {
                account.substract(Money.newInstance(sum, currency));
            }
        }
    }

    @Override
    protected String getFullName() {
        return name;
    }
}
