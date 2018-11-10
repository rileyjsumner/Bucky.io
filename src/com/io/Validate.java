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
      prompt(errorPrompt);
      return validIntInRange(min, max, prompt, errorPrompt);
    }
  }
  public double validDoubleInRange(double min, double max, String prompt, String errorPrompt) {
    double val = readDouble(prompt);
    if(val >= min && val <= max) {
      return val;
    } else {
      prompt(errorPrompt);
      return validDoubleInRange(min, max, prompt, errorPrompt);
    }
  }
  // validate str has length
  public String valideStrLength(int min, int max, String prompt, String errorPrompt) {
    String input = readStr(prompt);
    if(input.length() >= min && input.length() <= max) {
      return input;
    } else {
      prompt(errorPrompt);
      return valideStrLength(min, max, prompt, errorPrompt);
    }
  }

  public int intIsGreaterThan(int min, String prompt, String errorPrompt){
    int val = readInt(prompt);
    if(val >= min){
      return val;
    } else{
      prompt(errorPrompt);
      return intIsGreaterThan(min, prompt, errorPrompt);
    }
  }

  public int intIsLessThan(int max, String prompt, String errorPrompt){
    int val = readInt(prompt);
    if(val <= max){
      return val;
    } else{
      prompt(errorPrompt);
      return intIsLessThan(max, prompt, errorPrompt);
    }
  }

    public double doubleIsGreaterThan(double min, String prompt, String errorPrompt){
        double val = readInt(prompt);
        if(val >= min){
            return val;
        } else{
            prompt(errorPrompt);
            return doubleIsGreaterThan(min, prompt, errorPrompt);
        }
    }

    public double doubleIsLessThan(double max, String prompt, String errorPrompt){
        double val = readInt(prompt);
        if(val <= max){
            return val;
        } else{
            prompt(errorPrompt);
            return doubleIsLessThan(max, prompt, errorPrompt);
        }
    }

    public float floatIsGreaterThan(float min, String prompt, String errorPrompt){
        float val = readInt(prompt);
        if(val >= min){
            return val;
        } else{
            prompt(errorPrompt);
            return floatIsGreaterThan(min, prompt, errorPrompt);
        }
    }

    public float floatIsLessThan(float max, String prompt, String errorPrompt){
        float val = readInt(prompt);
        if(val <= max){
            return val;
        } else{
            prompt(errorPrompt);
            return floatIsLessThan(max, prompt, errorPrompt);
        }
    }



}
