package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class ArithmeticUtility {
  public double add(double o1, double o2) {
    return o1 + o2;
  }

  public double multiply(final double o1, final double o2) {
    return o2 * o1;
  }

  // Subtract two integers
  public double subtract(double o1, double o2) {
    return o1 - o2;
  }

  // divide two integers
  public double divide(double o1, double o2) {
    return o1 / o2;
  }

  public double exponent(double o1, int n) {
    // TODO: Implement me properly!
    if (n == 0) {
      return 1.0;
    }

    int power = (n < 0) ? -n : n;

    double result = 1.0;

    // KASUS 2: Looping perkalian
    for (int i = 0; i < power; i++) {
      result *= o1;
    }

    if (n < 0) {
      return 1.0 / result;
    }

    return result;
  }
}