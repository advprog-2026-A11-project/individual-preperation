package com.example.individualprep.service.arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import com.example.individualprep.service.ArithmeticUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplyArithmeticTests {

  private ArithmeticUtility util;

  @BeforeEach
  void setUp() {
    util = new ArithmeticUtility();
  }

  @Test
  void multiply_twoPositiveNumbers_returnsProduct() {
    assertEquals(6.0, util.multiply(2.0, 3.0), 1e-9);
  }

  @Test
  void multiply_byZero_returnsZero() {
    assertEquals(0.0, util.multiply(5.0, 0.0), 1e-9);
  }

  @Test
  void multiply_negativeAndPositive_returnsNegativeProduct() {
    assertEquals(-15.0, util.multiply(-3.0, 5.0), 1e-9);
  }

  @Test
  void multiply_isCommutative() {
    double a = 2.5;
    double b = -4.0;
    assertEquals(util.multiply(a, b), util.multiply(b, a), 1e-9);
  }

}
