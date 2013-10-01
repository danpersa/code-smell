package com.danix.code.smell.example001;

/**
 * @author danix
 */
public class AccountTestUtils {

    static Account getAccountByTypeAndMoney(boolean premium, double money) {
        AccountType accountType = new AccountType(premium);
        Account account = new Account(accountType, 9);
        account.setIban("RO023INGB434321431241");
        account.setMoney(Money.newEuro(money));
        return account;
    }
}
