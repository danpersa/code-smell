package com.danix.code.smell.example001;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import static com.danix.code.smell.example001.AccountTestUtils.getAccountByTypeAndMoney;
import static com.danix.code.smell.example001.CustomerTestUtils.getCompanyCustomer;

import org.junit.Test;

/**
 * @author  danix
 */
public class CompanyTest {

    private static final Money SOME_EURO = Money.newEuro(10);

    @Test
    public void testWithdrawCompanyWithNormalAccount() throws Exception {
        Account account = getAccountByTypeAndMoney(false, 34);
        Customer customer = getCompanyCustomer(account);
        customer.withdraw(SOME_EURO);
        assertThat(account.getMoneyAmount(), is(24.0));
    }

    @Test
    public void testWithdrawCompanyWithNormalAccountAndOverdraft() throws Exception {
        Account account = getAccountByTypeAndMoney(false, -10);
        Customer customer = getCompanyCustomer(account);
        customer.withdraw(SOME_EURO);
        assertThat(account.getMoneyAmount(), is(-21.0));
    }

    @Test
    public void testWithdrawCompanyWithPremiumAccount() throws Exception {
        Account account = getAccountByTypeAndMoney(true, 34);
        Customer customer = getCompanyCustomer(account);
        customer.withdraw(SOME_EURO);
        assertThat(account.getMoneyAmount(), is(24.0));
    }

    @Test
    public void testWithdrawCompanyWithPremiumAccountAndOverdraft() throws Exception {
        Account account = getAccountByTypeAndMoney(true, -10);
        Customer customer = getCompanyCustomer(account);
        customer.withdraw(SOME_EURO);
        assertThat(account.getMoneyAmount(), is(-20.25));
    }
}
