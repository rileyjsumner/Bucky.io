package com.Utility;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class LoginTest {

  @Test
  public void testCreateUser() {
    HashMap<String, Object> userInfo = new HashMap<>();
    userInfo.put("username", "testUser");
    userInfo.put("password", "testPass");
    Login login = new Login(userInfo, "usersTest");

    HashMap<String, String> userCreate = new HashMap<>();
    userCreate.put("username", "testUser");
    userCreate.put("password", "testPass");

    Assert.assertEquals(true, login.createUser(userCreate));
  }

  @Test
  public void testVerifyUsername() {
    HashMap<String, Object> userInfo = new HashMap<>();
    userInfo.put("username", "testUser");
    userInfo.put("password", "testPass");

    HashMap<String, String> userCreate = new HashMap<>();
    userCreate.put("username", "testUser");
    userCreate.put("password", "testPass");

    Login login = new Login(userInfo, "usersTest");

    Assert.assertEquals(true, login.verifyUsername("testUser", "username"));
  }
}
