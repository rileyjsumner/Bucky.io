package com.io;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Input {
  private Scanner in; // Scanner field

  /**
   * Constructor for Input class
   */
  public Input() {
    in = new Scanner(System.in);
  }

  /**
   * Accessor method for the class Scanner
   * @return Scanner field
   */
  public Scanner scan() {
    return in;
  }
  /**
   * Private helper method to print out a prompt queueing
   * user input - add a \n for new line
   * @param prompt Statement to ask user for input
   */
  protected void prompt(String prompt) {
    System.out.print(prompt);
  }

  /**
   * Requests a String keyboard input from user
   * @param prompt statement to ask for user input
   * @return input String from user
   */
  public String readStr(String prompt) {
    prompt(prompt);
    return in.nextLine();
  }

  /**
   * Requests an integer keyboard input from user
   * @param prompt statement to ask for user input
   * @return input integer from user
   */
  public int readInt(String prompt) {
    prompt(prompt);
    return in.nextInt();
  }

  /**
   * Requests a double keyboard input from user
   * @param prompt statement to ask user for input
   * @return input double from user
   */
  public double readDouble(String prompt) {
    prompt(prompt);
    return in.nextDouble();
  }

  public BigDecimal readBigDecimal(String prompt) {
    prompt(prompt);
    return in.nextBigDecimal();
  }

  public BigInteger readBigInteger(String prompt) {
    prompt(prompt);
    return in.nextBigInteger();
  }

  public boolean readBoolean(String prompt) {
    prompt(prompt);
    return in.nextBoolean();
  }

  public Byte readByte(String prompt) {
    prompt(prompt);
    return in.nextByte();
  }

  public float readFloat(String prompt) {
    prompt(prompt);
    return in.nextFloat();
  }

  public long readLong(String prompt) {
    prompt(prompt);
    return in.nextLong();
  }

  public Short readShort(String prompt) {
    prompt(prompt);
    return in.nextShort();
  }
}
