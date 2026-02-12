package com.example.individualprep.service.vector;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.individualprep.service.VectorUtility;

class SubtractVectorTests {

  private final VectorUtility util = new VectorUtility();

  @Test
  void subtractPositiveNumbers() {
    double[] v1 = { 5.0, 4.0, 3.0 };
    double[] v2 = { 1.0, 2.0, 3.0 };

    double[] expected = { 4.0, 2.0, 0.0 };
    assertArrayEquals(expected, util.subtract(v1, v2), 1e-9);
  }

  @Test
  void subtractNegativeAndMixed() {
    double[] v1 = { -1.0, -2.0, 7.5 };
    double[] v2 = { -3.0, 4.0, -2.5 };

    double[] expected = { 2.0, -6.0, 10.0 };
    assertArrayEquals(expected, util.subtract(v1, v2), 1e-9);
  }

  @Test
  void subtractEmptyVectors() {
    double[] v1 = new double[0];
    double[] v2 = new double[0];

    double[] expected = new double[0];
    assertArrayEquals(expected, util.subtract(v1, v2), 1e-9);
  }

  @Test
  void subtractMismatchedLengthsThrows() {
    double[] v1 = { 1.0, 2.0 };
    double[] v2 = { 1.0 };

    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
        () -> util.subtract(v1, v2));
    assertTrue(ex.getMessage().toLowerCase().contains("same length"));
  }

  @Test
  void subtractSingleElement() {
    double[] v1 = { 42.0 };
    double[] v2 = { 2.5 };

    double[] expected = { 39.5 };
    assertArrayEquals(expected, util.subtract(v1, v2), 1e-9);
  }

  @Test
  void subtractSpecialFloatingValues() {
    double[] v1 = { Double.POSITIVE_INFINITY, Double.NaN };
    double[] v2 = { 0.0, 0.0 };

    double[] result = util.subtract(v1, v2);
    assertEquals(Double.POSITIVE_INFINITY, result[0]);
    assertTrue(Double.isNaN(result[1]));
  }
}
