package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {

  public double[] add(double[] v1, double[] v2) {
    // TODO: Implement me properly!
    return new double[] { 0.0, 0.0, 0.0 };
  }

  public double[] subtract(double[] v1, double[] v2) {
    // TODO: Implement me properly!
    return new double[]{0.0, 0.0, 0.0};
  }

  public double[] multiply(double[] v1, int x) {
    // TODO: Implement me properly!
    return new double[]{0.0, 0.0, 0.0};
  }

  public double dotProduct(double[] v1, double[] v2) {
    // TODO: Implement me properly!
    return 0.0;
  }

  public double[] norm(double[] v1) {
    double sum = 0;

    for (double component : v1) {
      sum += component * component;
    }

    double magnitude = Math.sqrt(sum);
    if (magnitude == 0) {
      return v1;
    }

    double[] result = new double[v1.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = v1[i] / magnitude;
    }

    return result;
  }
}
