package com.danix.code.smell.example001;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import static com.danix.code.smell.example001.AccountTestUtils.getAccountByTypeAndMoney;
import static com.danix.code.smell.example001.CustomerTestUtils.getPersonCustomer;

import org.junit.Test;

/**
 * @author  danix
 */
public class PersonTest {

    public static final Money SOME_EURO = Money.newEuro(10);

    @Test
    public void testWithdrawPersonWithNormalAccount() throws Exception {
        Account account = getAccountByTypeAndMoney(false, 34.0);
        Customer customer = getPersonCustomer(account);
        customer.withdraw(SOME_EURO);
        assertThat(account.getMoneyAmount(), is(24.0));
    }

    @Test
    public void testWithdrawPersonWithNormalAccountAndOverdraft() throws Exception {
        Account account = getAccountByTypeAndMoney(false, -10.0);
        Customer customer = getPersonCustomer(account);
        customer.withdraw(SOME_EURO);
        assertThat(account.getMoneyAmount(), is(-22.0));
    }

    @Test
    public void testWithdrawPersonWithPremiumAccount() throws Exception {
        Account account = getAccountByTypeAndMoney(true, 34.0);
        Customer customer = getPersonCustomer(account);
        customer.withdraw(SOME_EURO);
        assertThat(account.getMoneyAmount(), is(24.0));
    }

    @Test
    public void testWithdrawPersonWithPremiumAccountAndOverdraft() throws Exception {
        Account account = getAccountByTypeAndMoney(true, -10.0);
        Customer customer = getPersonCustomer(account);
        customer.withdraw(SOME_EURO);
        assertThat(account.getMoneyAmount(), is(-21.0));
    }
}
