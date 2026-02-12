package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {

  public double[] add(double[] v1, double[] v2) {
    // TODO: Implement me properly!
    return new double[] { 0.0, 0.0, 0.0 };
  }

  public double[] subtract(double[] v1, double[] v2) {
    if (v1.length != v2.length) {
      throw new IllegalArgumentException("Two vectors must have the same length!");
    }

    double[] result = new double[v1.length];
    for (int i = 0; i < v1.length; i++) {
      result[i] = v1[i] - v2[i];
    }

    return result;
  }

  public double[] multiply(final double[] v1, final int x) {
    double[] result = new double[v1.length];
    for (int i = 0; i < v1.length; i++) {
      result[i] = v1[i] * x;
    }
    return result;
  }

  // Dot product of two vectors
  public double dotProduct(double[] v1, double[] v2) {
    // TODO: Implement me properly!

    // check if two vectors have the same length
    if (v1.length != v2.length) {
      throw new IllegalArgumentException("Two vectors must have the same length!");
    }

    double result = 0.0;
    for (int i = 0; i < v1.length; i++) {
      result += v1[i] * v2[i];
    }

    return result;
  }

  // Norm of a vector
  public double norm(double[] v1) {
    // TODO: Implement me properly!
    return 0.0;
  }
}
