package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DotProductVectorTests {

  private VectorUtility util;

  @BeforeEach
  void setUp() {
    util = new VectorUtility();
  }

  @Test
  void test_lengthNotSame() {
    double[] v1 = {1.0, 2.0};
    double[] v2 = {3.0, 4.0, 5.0};

    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> util.dotProduct(v1, v2));
    assertEquals("Two vectors must have the same length!", exception.getMessage());
  }

  @Test
  void dotProduct_emptyVectors() {
    double[] v1 = {};
    double[] v2 = {};

    assertEquals(0.0, util.dotProduct(v1, v2));
  }

  @Test
  void dotProduct_nullVector() {
    double[] v2 = {5.0, 3.0, 9.0};

    assertThrows(NullPointerException.class, () -> util.dotProduct(null, v2));
  }

  @Test
  void dotProduct_allZeros() {
    double[] v1 = {0.0, 0.0, 0.0};
    double[] v2 = {0.0, 0.0, 0.0};

    assertEquals(0.0, util.dotProduct(v1, v2));
  }

  @Test
  void dotProduct_withZeros() {
    double[] v1 = {1.0, 2.0, 3.0};
    double[] v2 = {0.0, 0.0, 0.0};
    double result = util.dotProduct(v1, v2);

    assertEquals(0.0, result);
  }

  @Test
  void dotProduct_allNegativeNumbers() {
    double[] v1 = {-1.0, -2.0, -3.0};
    double[] v2 = {-4.0, -5.0, -6.0};
    double result = util.dotProduct(v1, v2);

    assertEquals(32.0, result);
  }

  @Test
  void dotProduct_allPositiveNumbers() {
    double[] v1 = {11.0, 2.0, 3.0};
    double[] v2 = {8.0, 4.0, 10.0};
    double result = util.dotProduct(v1, v2);

    assertEquals(126.0, result);
  }

  @Test
  void dotProduct_positiveAnd_negativeNumbers() {
    double[] v1 = {3.0, -4.0, -5.0};
    double[] v2 = {-7.0, -8.0, 2.0};
    double result = util.dotProduct(v1, v2);

    assertEquals(1.0, result);

  }

}
