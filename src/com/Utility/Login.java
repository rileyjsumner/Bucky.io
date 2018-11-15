package com.Utility;

import com.Exception.IllegalUsernameAssignment;
import com.Model.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

public class Login extends Bean {
  private DAO loginDAO;
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

  public Login(HashMap<String, Object> fields, String db_table) {
    super(fields, "Login");
    this.loginDAO = new DAO(db_table);
  }

  /**
   * Tests database whether username already exists, returns boolean if username is valid
   * @param username is the login used by the user
   * @return boolean if username is available
   */
  public boolean verifyUsername(String username, String userCol)  {
    ArrayList<String> userList = new ArrayList<>();
    userList.add(userCol);
    HashMap<String, Object> usernameList = this.loginDAO.resultSetToHashMap(this.loginDAO.select(userList, "", "1"), userList);
    return usernameList.containsValue(username);
  }

  public String encrypt(String value) {
    return new String(Base64.getEncoder().encode(value.getBytes()));

  }

  public String decrypt(String value) {
    return new String(Base64.getDecoder().decode(value));
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
