package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {
  // Add two vectors
  public double[] add(double[] v1, double[] v2) {
    // TODO: Implement me properly!
    return new double[]{0.0, 0.0, 0.0};
  }

  // Substract two vectors
  public double[] subtract(double[] v1, double[] v2) {
    // TODO: Implement me properly!
    return new double[]{0.0, 0.0, 0.0};
  }

  // Multiply two vectors
  public double[] multiply(double[] v1, int x) {
    // TODO: Implement me properly!
    return new double[]{0.0, 0.0, 0.0};
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