package com.example.individualprep.service.vector;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.individualprep.service.VectorUtility;
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
}