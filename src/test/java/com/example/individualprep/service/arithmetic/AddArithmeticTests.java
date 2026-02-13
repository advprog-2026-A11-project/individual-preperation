package com.example.individualprep.service.arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import com.example.individualprep.service.ArithmeticUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddArithmeticTests {

  private ArithmeticUtility util;

  @BeforeEach
  void setUp() {
    util = new ArithmeticUtility();
  }

  @Test
  void add_twoPositiveNumbers() {
    assertEquals(15.5, util.add(10.0, 5.5), 1e-9);
  }

  @Test
  void add_positiveAndNegative() {
    assertEquals(2.0, util.add(5.0, -3.0), 1e-9);
    assertEquals(-2.0, util.add(-5.0, 3.0), 1e-9);
  }

  @Test
  void add_twoNegativeNumbers() {
    assertEquals(-10.0, util.add(-4.0, -6.0), 1e-9);
  }

  @Test
  void add_withZero() {
    assertEquals(7.0, util.add(7.0, 0.0), 1e-9);
    assertEquals(-3.0, util.add(0.0, -3.0), 1e-9);
  }

  @Test
  void add_isCommutative() {
    double a = 123.45;
    double b = 67.89;
    assertEquals(util.add(a, b), util.add(b, a), 1e-9);
  }

  @Test
  void add_largeValues() {
    // Testing boundary-like behavior with large doubles
    assertEquals(2000000.0, util.add(1000000.0, 1000000.0), 1e-9);
  }
}
