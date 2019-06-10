package Automat;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    @Test
    public void getValue() {
        Money money1 = new Money(5);
        Money money2 = new Money(10);
        Money money3 = new Money(0.1);
        assertEquals(5,money1.getValue(),0.000000001);
        assertEquals(10,money2.getValue(),0.000000001);
        assertEquals(0.1,money3.getValue(),0.000000001);
    }
}