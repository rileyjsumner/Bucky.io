package com.io;

public class Validate extends Input {
  // validate number in range

  /**
   * Detects if integer value is between specified range (range is inclusive
   * with values)
   * @param min smallest value (inclusive) to check
   * @param max largest value (inclusive) to check
   * @param prompt prompt to ask user for input
   * @return boolean if value falls in range
   */
  public boolean validIntInRange(int min, int max, String prompt) {
    int val = readInt(prompt);
    return (val >= min && val <= max);
  }
  public boolean validDoubleInRange(double min, double max, String prompt) {
    double val = readDouble(prompt);
    return (val >= min && val <= max);
  }
  // validate str has length
  // validate method to ask for user prompt again
  // handle input mismatch
}
