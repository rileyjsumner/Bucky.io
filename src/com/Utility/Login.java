package com.Utility;

import com.Model.DAO;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

public class Login extends Bean {
  private DAO loginDAO;
  private boolean isLogin;
  /*
  private int id;
  private String username;
  private String password;
  private String email;
  private String phoneNumber;
  private String link;
  private String street;
  private String city;
  private String state;
  private String zip;
  private Date birthdate;
  private char gender;
  private Date joinDate;
  */

  /**
   * Constructor for Login class
   * @param fields HashMap of initial fields
   * @param db_table name of users table
   */
  public Login(HashMap<String, Object> fields, String db_table) {
    super(fields, "Login");
    this.loginDAO = new DAO(db_table);
    this.isLogin = false;
  }

  /**
   * Tests database whether username already exists, returns boolean if username is valid
   * @param username is the login used by the user
   * @param userCol is the column which contains the username
   * @return boolean if username is available
   */
  public boolean verifyUsername(String username, String userCol)  {
    ArrayList<String> userList = new ArrayList<>();
    userList.add(userCol);
    HashMap<String, Object> usernameList = this.loginDAO.resultSetToHashMap(this.loginDAO.select(userList, "", "1"), userList);
    return usernameList.containsValue(username);
  }

  /**
   * Encrypts a string to be inserted into the database
   * @param value of string to be encrypted
   * @return new encrypted String
   */
  public String encrypt(String value) {
    return new String(Base64.getEncoder().encode(value.getBytes()));

  }

  /**
   * Decrypts a string returned from the database
   * @param value of string to be decrypted
   * @return new decrypted String
   */
  public String decrypt(String value) {
    return new String(Base64.getDecoder().decode(value));
  }

  /**
   * The createUser method creates a user from the given information and inserts that data into the
   * database
   * @param userInfo is a HashMap containing information about the users to be inserted into the
   * database
   * @return boolean if user creation was successful
   */
  public boolean createUser(HashMap<String, String> userInfo) {
    return loginDAO.insertStr(userInfo);
  }




  /*
   * Verify username
  Verify Password
  getField
  setField
  encrypt
  decrypt
  createAcct
  updateAcct
  deleteAcct
  isLogin / setLogin
   */

}
