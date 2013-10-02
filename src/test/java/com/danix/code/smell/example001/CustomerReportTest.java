package com.danix.code.smell.example001;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import static com.danix.code.smell.example001.CustomerTestUtils.getAccount;
import static com.danix.code.smell.example001.CustomerTestUtils.getPersonCustomer;

import org.junit.Test;

/**
 * @author  dpersa
 */
public class CustomerReportTest {

    @Test
    public void testPrintCustomerDaysOverdrawn() throws Exception {
        Account account = getAccount(false);
        Customer customer = getPersonCustomer(account);
        CustomerReport customerReport = new CustomerReport(customer, account);
        assertThat(customerReport.printCustomerDaysOverdrawn(),
            is("danix dan Account: IBAN: RO023INGB434321431241, Days Overdrawn: 9"));
    }

    @Test
    public void testPrintCustomerMoney() throws Exception {
        Account account = getAccount(false);
        Customer customer = getPersonCustomer(account);
        CustomerReport customerReport = new CustomerReport(customer, account);
        assertThat(customerReport.printCustomerMoney(),
            is("danix dan Account: IBAN: RO023INGB434321431241, Money: 34.0"));
    }

    @Test
    public void testPrintCustomerAccountNormal() throws Exception {
        Account account = getAccount(false);
        Customer customer = getPersonCustomer(account);
        CustomerReport customerReport = new CustomerReport(customer, account);
        assertThat(customerReport.printCustomerAccount(),
            is("Account: IBAN: RO023INGB434321431241, Money: 34.0, Account type: normal"));
    }

    @Test
    public void testPrintCustomerAccountPremium() throws Exception {
        Account account = getAccount(true);
        Customer customer = getPersonCustomer(account);
        CustomerReport customerReport = new CustomerReport(customer, account);
        assertThat(customerReport.printCustomerAccount(),
            is("Account: IBAN: RO023INGB434321431241, Money: 34.0, Account type: premium"));
    }

    @Test
    public void testPrintCustomer() {
        Account account = getAccount(false);
        Customer customer = getPersonCustomer(account);
        CustomerReport customerReport = new CustomerReport(customer, account);
        assertThat(customerReport.printCustomer(), is("danix dan@mail.com"));
    }
}
