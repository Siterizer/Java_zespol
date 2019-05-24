package Automat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void getValue() {
        Money money1 = new Money(5);
        Money money2 = new Money(10);
        Money money3 = new Money(0.1);
        assertEquals(5,money1.getValue());
        assertEquals(10,money2.getValue());
        assertEquals(0.1,money3.getValue());
    }
}