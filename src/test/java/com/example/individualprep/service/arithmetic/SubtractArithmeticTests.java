package com.example.individualprep.service.arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import com.example.individualprep.service.ArithmeticUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubtractArithmeticTests {

  private ArithmeticUtility util;

  @BeforeEach
  void setUp() {
    util = new ArithmeticUtility();
  }

  @Test
  void subtract_positiveNumber_withZero() {
    double result = util.subtract(9.0, 0.0);
    assertEquals(9.0, result);
  }

  @Test
  void subtract_negativeNumber_withZero() {
    double result = util.subtract(-3.0, 0.0);
    assertEquals(-3.0, result);
  }

  @Test
  void subtract_zeroWithPositiveNumber() {
    double result = util.subtract(0.0, 7.0);
    assertEquals(-7.0, result);
  }

  @Test
  void subtract_zeroWithNegativeNumber() {
    double result = util.subtract(0.0, -5.0);
    assertEquals(5.0, result);
  }

  @Test
  void subtract_twoPositiveNumbers() {

    // case 1: num1 is bigger than num2
    double result = util.subtract(9.0, 7.0);
    assertEquals(2.0, result);

    // case 2: num2 is bigger than num1
    double result2 = util.subtract(5.0, 11.0);
    assertEquals(-6.0, result2);

    // case 3: num1 == num2
    double result3 = util.subtract(4.0, 4.0);
    assertEquals(0.0, result3);
  }

  @Test
  void subtract_twoNegativeNumbers() {

    // case 1: num1 is bigger than num2
    double result = util.subtract(-2.0, -9.0);
    assertEquals(7.0, result);

    // case 2: num2 is bigger than num2
    double result2 = util.subtract(-9.0, -2.0);
    assertEquals(-7.0, result2);

    // case 3: num1 == num2
    double result3 = util.subtract(-8.0, -8.0);
    assertEquals(0.0, result3);
  }

  @Test
  void subtract_positiveNumber_withNegativeNumber() {
    // case 1; num1 = positive, num2 = negative
    double result = util.subtract(4.0, -2.0);
    assertEquals(6.0, result);

    // case 2: num1 = negative, num2 = positive
    double result2 = util.subtract(-4.0, 5.0);
    assertEquals(-9.0, result2);
  }
}
