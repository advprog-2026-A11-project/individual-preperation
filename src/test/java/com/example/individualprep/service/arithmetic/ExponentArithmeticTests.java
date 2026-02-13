package com.example.individualprep.service.arithmetic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.individualprep.service.ArithmeticUtility;
import org.junit.jupiter.api.Test;

class ExponentArithmeticTests {

    private final ArithmeticUtility util = new ArithmeticUtility();

    @Test
    void testExponentPositive() {
        assertEquals(8.0, util.exponent(2.0, 3), 1e-9);
    }

    @Test
    void testExponentZero() {
        assertEquals(1.0, util.exponent(100.0, 0), 1e-9);
    }

    @Test
    void testExponentNegative() {
        assertEquals(0.5, util.exponent(2.0, -1), 1e-9);
    }
}