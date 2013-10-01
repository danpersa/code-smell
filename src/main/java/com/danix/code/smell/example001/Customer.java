package com.danix.code.smell.example001;

/**
 * @author danix
 */
public abstract class Customer {

    protected String name;
    protected String email;
    protected Account account;

    Customer(String name, String email, Account account) {
        this.name = name;
        this.email = email;
        this.account = account;
    }

    public abstract void withdraw(double sum, String currency);

    abstract protected String getFullName();

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

    public String printCustomerDaysOverdrawn() {
        String fullName = getFullName();

        String accountDescription = "Account: IBAN: " + account.getIban()
                + ", Days Overdrawn: " + account.getDaysOverdrawn();
        return fullName + accountDescription;
    }

    public String printCustomerMoney() {
        String fullName = getFullName();
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + account.getIban() + ", Money: " + account.getMoneyAmount();
        return fullName + accountDescription;
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + account.getIban() + ", Money: "
                + account.getMoneyAmount() + ", Account type: " + account.getType();
    }
}
