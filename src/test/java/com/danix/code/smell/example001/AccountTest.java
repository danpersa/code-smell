package com.danix.code.smell.example001;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author danix
 */
public class AccountTest {

    @Test
    public void testBankchargePremiumLessThanAWeek() {
        AccountType premium = new AccountType(true);
        Account account = new Account(premium, 5);
        assertThat(account.bankcharge(), is(14.5));
    }

    @Test
    public void testBankchargePremiumMoreThanAWeek() {
        AccountType premium = new AccountType(true);
        Account account = new Account(premium, 9);
        assertThat(account.bankcharge(), is(16.5));
    }


    @Test
    public void testOverdraftFeePremium() {
        AccountType premium = new AccountType(true);
        Account account = new Account(premium, 9);
        assertThat(account.overdraftFee(), is(0.10));
    }

    @Test
    public void testOverdraftFeeNotPremium() {
        AccountType premium = new AccountType(false);
        Account account = new Account(premium, 9);
        assertThat(account.overdraftFee(), is(0.20));
    }

    @Test
    public void testPrintCustomer() {
        AccountType premium = new AccountType(false);
        Account account = new Account(premium, 9);
        Customer customer = new Customer("danix", "dan", "dan@mail.com", CustomerType.PERSON, account);
        account.setCustomer(customer);
        assertThat(account.printCustomer(), is("danix dan@mail.com"));
    }
}
