package com.io;


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
   * user input
   * @param prompt Statement to ask user for input
   */
  private void prompt(String prompt) {
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
}
