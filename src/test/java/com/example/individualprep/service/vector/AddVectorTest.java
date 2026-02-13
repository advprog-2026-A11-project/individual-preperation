package com.example.individualprep.service.vector;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.individualprep.service.VectorUtility;
import org.junit.jupiter.api.Test;

class AddVectorTests {

    private final VectorUtility util = new VectorUtility();

    @Test
    void addPositiveNumbers() {
        double[] v1 = { 5.0, 4.0, 3.0 };
        double[] v2 = { 1.0, 2.0, 3.0 };

        double[] expected = { 6.0, 6.0, 6.0 };
        assertArrayEquals(expected, util.add(v1, v2), 1e-9);
    }

    @Test
    void addNegativeAndMixed() {
        double[] v1 = { -1.0, -2.0, 7.5 };
        double[] v2 = { -3.0, 4.0, -2.5 };

        double[] expected = { -4.0, 2.0, 5.0 };
        assertArrayEquals(expected, util.add(v1, v2), 1e-9);
    }

    @Test
    void addEmptyVectors() {
        double[] v1 = new double[0];
        double[] v2 = new double[0];

        double[] expected = new double[0];
        assertArrayEquals(expected, util.add(v1, v2), 1e-9);
    }

    @Test
    void addMismatchedLengthsThrows() {
        double[] v1 = { 1.0, 2.0 };
        double[] v2 = { 1.0 };

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> util.add(v1, v2));

        assertTrue(ex.getMessage().toLowerCase().contains("equal") ||
                ex.getMessage().toLowerCase().contains("length"));
    }

    @Test
    void addSingleElement() {
        double[] v1 = { 42.0 };
        double[] v2 = { 2.5 };

        double[] expected = { 44.5 };
        assertArrayEquals(expected, util.add(v1, v2), 1e-9);
    }

    @Test
    void addSpecialFloatingValues() {
        double[] v1 = { Double.POSITIVE_INFINITY, Double.NaN };
        double[] v2 = { 0.0, 0.0 };

        double[] result = util.add(v1, v2);
        assertEquals(Double.POSITIVE_INFINITY, result[0]);
        assertTrue(Double.isNaN(result[1]));
    }
}