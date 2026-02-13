package com.example.individualprep.service.vector;

import com.example.individualprep.service.VectorUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplyVectorTests {

  private VectorUtility util;

  @BeforeEach
  void setUp() {
    util = new VectorUtility();
  }

  @Test
  void multiply_withPositiveMultiplier_returnsScaledVector() {
    double[] v = {1.0, 2.0, -3.5};
    int m = 3;
    double[] expected = {3.0, 6.0, -10.5};

    double[] result = util.multiply(v, m);

    Assertions.assertArrayEquals(expected, result, 1e-9);
    Assertions.assertNotSame(v, result, "returns new array");
  }

  @Test
  void multiply_withZeroMultiplier_returnsZeroVector() {
    double[] v = {1.2, -4.5, 0.0};
    double[] expected = {0.0, 0.0, 0.0};

    double[] result = util.multiply(v, 0);

    Assertions.assertArrayEquals(expected, result, 1e-9);
  }

  @Test
  void multiply_withNegativeMultiplier_returnsScaledVector() {
    double[] v = {2.0, -1.5};
    double[] expected = {-4.0, 3.0};

    double[] result = util.multiply(v, -2);

    Assertions.assertArrayEquals(expected, result, 1e-9);
  }

  @Test
  void multiply_withEmptyArray_returnsEmptyArray() {
    double[] v = new double[0];

    double[] result = util.multiply(v, 5);

    Assertions.assertEquals(0, result.length);
  }

  @Test
  void multiply_doesNotModifyOriginalArray() {
    double[] v = {7.0, -3.0};
    double[] original = v.clone();

    util.multiply(v, 4);

    Assertions.assertArrayEquals(original, v, 1e-9);
  }

  @Test
  void multiply_withNull_throwsNullPointerException() {
    Assertions.assertThrows(NullPointerException.class, () -> util.multiply(null, 2));
  }
}