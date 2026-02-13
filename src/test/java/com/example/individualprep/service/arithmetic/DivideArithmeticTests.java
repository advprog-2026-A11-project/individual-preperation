package com.example.individualprep.service.arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import com.example.individualprep.service.ArithmeticUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivideArithmeticTests {

  private ArithmeticUtility util;

  @BeforeEach
  void setUp() {
    util = new ArithmeticUtility();
  }

  @Test
  void divide_twoPositiveNumbers_returnsQuotient() {
    assertEquals(2.0, util.divide(6.0, 3.0), 1e-9);
  }

  @Test
  void divide_positiveByNegative_returnsNegativeQuotient() {
    assertEquals(-2.0, util.divide(6.0, -3.0), 1e-9);
  }

  @Test
  void divide_zeroNumerator_returnsZero() {
    assertEquals(0.0, util.divide(0.0, 5.0), 1e-9);
  }

  @Test
  void divide_divideByZero_returnsInfinity() {
    assertEquals(Double.POSITIVE_INFINITY, util.divide(1.0, 0.0));
  }

  @Test
  void divide_divideByNegativeZero_returnsNegativeInfinity() {
    assertEquals(Double.NEGATIVE_INFINITY, util.divide(1.0, -0.0));
  }

  @Test
  void divide_zeroByZero_returnsNaN() {
    assertTrue(Double.isNaN(util.divide(0.0, 0.0)));
  }
}
