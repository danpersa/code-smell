package com.danix.code.smell.example001;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author danix
 */
public class AccountTest {

    private CustomerFactory customerFactory;

    @Before
    public void setUp() {
        customerFactory = new CustomerFactory();
    }

    @Test
    public void testBankchargePremiumLessThanAWeek() {
        Account account = getPremiumAccount(5);
        assertThat(account.bankcharge(), is(14.5));
    }

    @Test
    public void testBankchargePremiumMoreThanAWeek() {
        Account account = getPremiumAccount(9);
        assertThat(account.bankcharge(), is(16.5));
    }

    @Test
    public void testOverdraftFeePremium() {
        Account account = getPremiumAccount(9);
        assertThat(account.overdraftFee(), is(0.10));
    }

    @Test
    public void testOverdraftFeeNotPremium() {
        Account account = getNormalAccount();
        assertThat(account.overdraftFee(), is(0.20));
    }

    @Test
    public void testPrintCustomer() {
        Account account = getNormalAccount();
        Customer customer = customerFactory.createPerson("danix", "dan", "dan@mail.com", account);
        account.setCustomer(customer);
        assertThat(account.printCustomer(), is("danix dan@mail.com"));
    }

    private Account getNormalAccount() {
        AccountType premium = new AccountType(false);
        return new Account(premium, 9);
    }

    private Account getPremiumAccount(int daysOverdrawn) {
        AccountType normal = new AccountType(true);
        return new Account(normal, daysOverdrawn);
    }
}
