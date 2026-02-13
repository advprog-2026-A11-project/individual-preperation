package com.example.individualprep.service.vector;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.individualprep.service.VectorUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NormVectorTests {

  private final VectorUtility util = new VectorUtility();

  @Test
  @DisplayName("norm: normalize standard positive vector")
  void normPositiveNumbers() {
    // Vector {3, 4} has magnitude sqrt(3^2 + 4^2) = 5
    double[] v1 = { 3.0, 4.0 };
    double[] expected = { 0.6, 0.8 }; // 3/5 and 4/5

    assertArrayEquals(expected, util.norm(v1), 1e-9);
  }

  @Test
  @DisplayName("norm: verify unit length (magnitude is 1.0)")
  void normVerifyMagnitude() {
    double[] v1 = { 1.0, 2.0, 3.0 };
    double[] normalized = util.norm(v1);

    double sum = 0;
    for (double component : normalized) {
      sum += component * component;
    }
    double magnitude = Math.sqrt(sum);

    assertEquals(1.0, magnitude, 1e-9);
  }

  @Test
  @DisplayName("norm: zero vector returns original vector (magnitude 0)")
  void normZeroVector() {
    double[] v1 = { 0.0, 0.0, 0.0 };
    double[] expected = { 0.0, 0.0, 0.0 };

    assertArrayEquals(expected, util.norm(v1), 1e-9);
  }

  @Test
  @DisplayName("norm: negative components")
  void normNegativeComponents() {
    double[] v1 = { -1.0, 1.0 };
    // Magnitude = sqrt(1+1) = sqrt(2) approx 1.414...
    double mag = Math.sqrt(2.0);
    double[] expected = { -1.0 / mag, 1.0 / mag };

    assertArrayEquals(expected, util.norm(v1), 1e-9);
  }

  @Test
  @DisplayName("norm: single element vector returns 1.0 or -1.0")
  void normSingleElement() {
    double[] v1 = { 5.0 };
    double[] expected = { 1.0 };
    assertArrayEquals(expected, util.norm(v1), 1e-9);

    double[] v2 = { -42.0 };
    double[] expected2 = { -1.0 };
    assertArrayEquals(expected2, util.norm(v2), 1e-9);
  }

  @Test
  @DisplayName("norm: empty vector (edge case)")
  void normEmptyVector() {
    double[] v1 = new double[0];
    double[] result = util.norm(v1);

    assertEquals(0, result.length);
  }

  static class MultiplyVectorTests {

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

      assertArrayEquals(expected, result, 1e-9);
      Assertions.assertNotSame(v, result, "returns new array");
    }

    @Test
    void multiply_withZeroMultiplier_returnsZeroVector() {
      double[] v = {1.2, -4.5, 0.0};
      double[] expected = {0.0, 0.0, 0.0};

      double[] result = util.multiply(v, 0);

      assertArrayEquals(expected, result, 1e-9);
    }

    @Test
    void multiply_withNegativeMultiplier_returnsScaledVector() {
      double[] v = {2.0, -1.5};
      double[] expected = {-4.0, 3.0};

      double[] result = util.multiply(v, -2);

      assertArrayEquals(expected, result, 1e-9);
    }

    @Test
    void multiply_withEmptyArray_returnsEmptyArray() {
      double[] v = new double[0];

      double[] result = util.multiply(v, 5);

      assertEquals(0, result.length);
    }

    @Test
    void multiply_doesNotModifyOriginalArray() {
      double[] v = {7.0, -3.0};
      double[] original = v.clone();

      util.multiply(v, 4);

      assertArrayEquals(original, v, 1e-9);
    }

    @Test
    void multiply_withNull_throwsNullPointerException() {
      Assertions.assertThrows(NullPointerException.class, () -> util.multiply(null, 2));
    }
  }
}