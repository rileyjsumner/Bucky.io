package com.io;

public class Validate extends Input {

  /**
   * Detects if integer value is between specified range (range is inclusive
   * with values)
   * @param min smallest value (inclusive) to check
   * @param max largest value (inclusive) to check
   * @param prompt prompt to ask user for input
   * @param errorPrompt if value is invalid
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

  /**
   * Detects if double value is between specified range (range is inclusive
   * with values)
   * @param min smallest value (inclusive) to check
   * @param max largest value (inclusive) to check
   * @param prompt prompt to ask user for input
   * @param errorPrompt if value is invalid
   * @return boolean if value falls in range
   */
  public double validDoubleInRange(double min, double max, String prompt, String errorPrompt) {
    double val = readDouble(prompt);
    if(val >= min && val <= max) {
      return val;
    } else {
      prompt(errorPrompt);
      return validDoubleInRange(min, max, prompt, errorPrompt);
    }
  }

  /**
   * Detects if String value's length is between specified range (range is inclusive
   * with values)
   * @param min smallest value (inclusive) to check
   * @param max largest value (inclusive) to check
   * @param prompt prompt to ask user for input
   * @param errorPrompt if value is invalid
   * @return boolean if value falls in range
   */
  public String valideStrLength(int min, int max, String prompt, String errorPrompt) {
    String input = readStr(prompt);
    if(input.length() >= min && input.length() <= max) {
      return input;
    } else {
      prompt(errorPrompt);
      return valideStrLength(min, max, prompt, errorPrompt);
    }
  }

  /**
   * Tests if integer value is greater than a specified minimum
   * @param min value to test input against (inclusive)
   * @param prompt prompt to ask user for input
   * @param errorPrompt if value is invalid
   * @return boolean if value falls in range
   */
  public int intIsGreaterThan(int min, String prompt, String errorPrompt){
    int val = readInt(prompt);
    if(val >= min){
      return val;
    } else{
      prompt(errorPrompt);
      return intIsGreaterThan(min, prompt, errorPrompt);
    }
  }

  /**
   * Tests if integer value is less than a specified maximum
   * @param max value to test input against (inclusive)
   * @param prompt prompt to ask user for input
   * @param errorPrompt if value is invalid
   * @return boolean if value falls in range
   */
  public int intIsLessThan(int max, String prompt, String errorPrompt){
    int val = readInt(prompt);
    if(val <= max){
      return val;
    } else{
      prompt(errorPrompt);
      return intIsLessThan(max, prompt, errorPrompt);
    }
  }

  /**
   * Tests if double value is greater than a specified minimum
   * @param min value to test input against (inclusive)
   * @param prompt prompt to ask user for input
   * @param errorPrompt if value is invalid
   * @return boolean if value falls in range
   */
  public double doubleIsGreaterThan(double min, String prompt, String errorPrompt){
      double val = readDouble(prompt);
      if(val >= min){
          return val;
      } else{
          prompt(errorPrompt);
          return doubleIsGreaterThan(min, prompt, errorPrompt);
      }
  }

  /**
   * Tests if double value is less than a specified maximum
   * @param max value to test input against (inclusive)
   * @param prompt prompt to ask user for input
   * @param errorPrompt if value is invalid
   * @return boolean if value falls in range
   */
  public double doubleIsLessThan(double max, String prompt, String errorPrompt){
      double val = readDouble(prompt);
      if(val <= max){
          return val;
      } else{
          prompt(errorPrompt);
          return doubleIsLessThan(max, prompt, errorPrompt);
      }
  }

  /**
   * Tests if float value is greater than a specified minimum
   * @param min value to test input against (inclusive)
   * @param prompt prompt to ask user for input
   * @param errorPrompt if value is invalid
   * @return boolean if value falls in range
   */
  public float floatIsGreaterThan(float min, String prompt, String errorPrompt){
      float val = readFloat(prompt);
      if(val >= min){
          return val;
      } else{
          prompt(errorPrompt);
          return floatIsGreaterThan(min, prompt, errorPrompt);
      }
  }

  /**
   * Tests if float value is less than a specified maximum
   * @param max value to test input against (inclusive)
   * @param prompt prompt to ask user for input
   * @param errorPrompt if value is invalid
   * @return boolean if value falls in range
   */
  public float floatIsLessThan(float max, String prompt, String errorPrompt){
      float val = readFloat(prompt);
      if(val <= max){
          return val;
      } else {
          prompt(errorPrompt);
          return floatIsLessThan(max, prompt, errorPrompt);
      }
  }

  public String strContains(CharSequence strContain, String prompt, String errorPrompt) {
    String str = readStr(prompt);
    if(str.contains(strContain)) {
      return str;
    } else {
      prompt(errorPrompt);
      return strContains(strContain, prompt, errorPrompt);
    }
  }
}
