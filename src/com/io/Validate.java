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
  public int validIntInRange(int min, int max, String prompt, String errorPrompt) {
    int val = readInt(prompt);
    if(val >= min && val <= max) {
      return val;
    } else {
      System.out.println(errorPrompt);
      validIntInRange(min, max, prompt, errorPrompt);
    }
    return -1;
  }
  public double validDoubleInRange(double min, double max, String prompt, String errorPrompt) {
    double val = readDouble(prompt);
    if(val >= min && val <= max) {
      return val;
    } else {
      System.out.println(errorPrompt);
      validDoubleInRange(min, max, prompt, errorPrompt);
    }
    return -1.0;
  }
  // validate str has length
  public String valideStrLength(int min, int max, String prompt, String errorPrompt) {
    String input = readStr(prompt);
    if(input.length() >= min && input.length() <= max) {
      return input;
    } else {
      System.out.println(errorPrompt);
      valideStrLength(min, max, prompt, errorPrompt);
    }
    return "";
  }
  // validate method to ask for user prompt again
  // handle input mismatch
}
