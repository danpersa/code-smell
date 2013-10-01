package com.danix.code.smell.example001;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author danix
 */
public class MoneyTest {


    @Test
    public void testSubstract() throws Exception {
        Money difference = Money.newEuro(20.0).substract(Money.newEuro(10.0));
        Assert.assertThat(difference.getAmount(), is(10.0));
        Assert.assertThat(difference.getCurrency(), is(Money.EUR_CURRENCY));
    }

    @Test
    public void testSubstractNegative() throws Exception {
        Money difference = Money.newEuro(20.0).substract(Money.newEuro(100.0));
        Assert.assertThat(difference.getAmount(), is(-80.0));
        Assert.assertThat(difference.getCurrency(), is(Money.EUR_CURRENCY));
    }

    @Test(expected = RuntimeException.class)
    public void testSubstractDifferentCurrencies() throws Exception {
        Money.newEuro(20.0).substract(Money.newInstance(10.0, "USD"));
    }
}
