package com.Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DAOTest {
  /**
   *
   */
  @Test
  public void testInsertStrWithColumnNotExisting() {
    DAO testDao = new DAO();
    String TABLE_NAME = "test";
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("user", "user");
    insertTest.put("pass", "password");
    Assert.assertEquals(false, testDao.insertStr(TABLE_NAME, insertTest));
  }

  /**
   * 
   */
  @Test
  public void testInsertStrWithUserAndPasswordValidStrings() {
    DAO testDao = new DAO();
    String TABLE_NAME = "test";
    HashMap<String, String> insertTest = new HashMap<>();
    insertTest.put("username", "user");
    insertTest.put("password", "password");
    Assert.assertEquals(true, testDao.insertStr(TABLE_NAME, insertTest));
  }
}
