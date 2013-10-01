package com.danix.code.smell.example001;

/**
 * @author danix
 */
public class Customer {

    private String name;
    private String surname;
    private String email;
    private CustomerType customerType;
    private Account account;
    private double companyOverdraftDiscount = 1;

    Customer(String name, String surname, String email, CustomerType customerType,
             Account account, double companyOverdraftDiscount) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.customerType = customerType;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public void withdraw(double sum, String currency) {
        if (account.getType().isPremium()) {
            switch (customerType) {
                case COMPANY:
                    if (account.isOverdraft()) {
                        // 50 percent discount for overdraft for premium account
                        account.substract(Money.newInstance(sum + sum * account.overdraftFee() * companyOverdraftDiscount / 2, currency));
                    } else {
                        account.substract(Money.newInstance(sum, currency));
                    }
                    break;
                case PERSON:
                    if (account.isOverdraft()) {
                        account.substract(Money.newInstance(sum + sum * account.overdraftFee(), currency));
                    } else {
                        account.substract(Money.newInstance(sum, currency));
                    }
                    break;
            }
        } else {
            switch (customerType) {
                case COMPANY:
                    if (account.isOverdraft()) {
                        // no discount for overdraft for not premium account
                        account.substract(Money.newInstance(sum + sum * account.overdraftFee() * companyOverdraftDiscount, currency));
                    } else {
                        account.substract(Money.newInstance(sum, currency));
                    }
                    break;
                case PERSON:
                    if (account.isOverdraft()) {
                        account.substract(Money.newInstance(sum + sum * account.overdraftFee(), currency));
                    } else {
                        account.substract(Money.newInstance(sum, currency));
                    }
                    break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String printCustomerDaysOverdrawn() {
        String fullName = name + " " + surname + " ";

        String accountDescription = "Account: IBAN: " + account.getIban() + ", Days Overdrawn: " + account.getDaysOverdrawn();
        return fullName + accountDescription;
    }

    public String printCustomerMoney() {
        String fullName = name + " " + surname + " ";
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + account.getIban() + ", Money: " + account.getMoneyAmount();
        return fullName + accountDescription;
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + account.getIban() + ", Money: "
                + account.getMoneyAmount() + ", Account type: " + account.getType();
    }
}
